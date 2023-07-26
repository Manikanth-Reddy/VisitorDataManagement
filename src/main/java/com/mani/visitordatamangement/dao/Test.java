package com.mani.visitordatamangement.dao;

import com.mani.visitordatamangement.dto.Admin;

public class Test {

	public static void main(String[] args) {
		AdminDAOImp imp = new AdminDAOImp();
		Admin admin = new Admin();
		admin.setUsername("manikanth");
		admin.setPassword("Manikanth!4289");
		imp.saveAdmin(admin);
	}

}
