package com.mani.visitordatamangement.dao;

import com.mani.visitordatamangement.dto.Admin;

public interface AdminDAO {
	public String saveAdmin(Admin admin);

	public Admin adminLogin(String user, String Pass);
}
