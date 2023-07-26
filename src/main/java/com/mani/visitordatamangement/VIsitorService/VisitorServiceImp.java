package com.mani.visitordatamangement.VIsitorService;

import java.util.List;
import java.util.stream.Collectors;

import com.mani.visitordatamangement.dao.VisitorDAO;
import com.mani.visitordatamangement.dao.VisitorDAOImplimentation;
import com.mani.visitordatamangement.dto.Visitor;

public class VisitorServiceImp implements VisitorService {
	VisitorDAO dao = null;

	public VisitorServiceImp() {
		dao = new VisitorDAOImplimentation();
	}

	@Override
	public String saveVisitor(Visitor visitor) {
	
		return dao.saveVisitor(visitor);
	}

	@Override
	public String updateVisitor(Visitor visitor) {

		return dao.updateVisitor(visitor);
	}

	@Override
	public Visitor deleteVisitor(int id) {
		Visitor vs = dao.deleteVisitor(id);
		
		return vs;
	}

	@Override
	public Visitor getVisitorById(int id) {
		Visitor vs = dao.getVisitorById(id);
		
		return vs;
	}

	@Override
	public Visitor getVisitorByContact(String contact) {
		
		Visitor vs = dao.getVisitorByContact(contact);
		
		return vs;
	}

	@Override
	public Visitor getVisitorByEmail(String Email) {
		Visitor vs = dao.getVisitorByEmail(Email);
		return vs;
	}

	@Override
	public List<Visitor> getAllVisitor() {
		List<Visitor> visitors = dao.getAllVisitor();
		return visitors.stream().map(e -> {
			e.setName(e.getName().toUpperCase());
			e.setCourse(e.getCourse().toUpperCase());
			e.setDegree(e.getDegree().toUpperCase());
			e.setStream(e.getStream().toUpperCase());
			return e;
		}).collect(Collectors.toList());
	}

	@Override
	public List<Visitor> getAllVisitorDataSortedByDegree() {
		return dao.getAllVisitorByDegree();
	}

	@Override
	public List<Visitor> getAllVisitorDataSortedByName() {
		List<Visitor> visitors = getAllVisitor();
		return visitors.stream().sorted((e1, e2) -> {
			return e1.getName().compareToIgnoreCase(e2.getName());
		}).collect(Collectors.toList());
	}

}
