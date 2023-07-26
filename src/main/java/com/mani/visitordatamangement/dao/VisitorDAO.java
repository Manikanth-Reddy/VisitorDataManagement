package com.mani.visitordatamangement.dao;

import java.util.List;

import com.mani.visitordatamangement.dto.*;

public interface VisitorDAO {
	public String saveVisitor(Visitor visitor);
	public String updateVisitor(Visitor visitor);
	public Visitor deleteVisitor(int id);
	public Visitor getVisitorById(int id);
	public Visitor getVisitorByEmail(String email);
	public List<Visitor> getAllVisitor();
	public List<Visitor> getAllVisitorByDegree();
	public Visitor getVisitorByContact(String Contact);
}
