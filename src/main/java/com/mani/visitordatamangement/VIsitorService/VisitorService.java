package com.mani.visitordatamangement.VIsitorService;

import java.util.List;

import com.mani.visitordatamangement.dto.Visitor;

public interface VisitorService {
	public String saveVisitor(Visitor visitor);
	public String updateVisitor(Visitor visitor);
	public Visitor deleteVisitor(int id);
	public Visitor getVisitorById(int id);
	public Visitor getVisitorByContact(String contact);
	public Visitor getVisitorByEmail(String Email);
	public List<Visitor> getAllVisitor();
	public List<Visitor> getAllVisitorDataSortedByName();
	public List<Visitor> getAllVisitorDataSortedByDegree();
}
