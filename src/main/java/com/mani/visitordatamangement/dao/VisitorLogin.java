package com.mani.visitordatamangement.dao;
import com.mani.visitordatamangement.dto.*;
public interface VisitorLogin {
	public String register(VisitorLoginDetails visitor);

	public VisitorLoginDetails login(String user, String Pass);
}
