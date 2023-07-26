package com.mani.visitordatamangement.controller;

import java.util.Scanner;

import com.mani.visitordatamangement.VIsitorService.VisitorService;
import com.mani.visitordatamangement.VIsitorService.VisitorServiceImp;
import com.mani.visitordatamangement.dao.AdminDAO;
import com.mani.visitordatamangement.dao.AdminDAOImp;
import com.mani.visitordatamangement.dto.Admin;
import com.mani.visitordatamangement.dto.Visitor;

public class FrotEndPart {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		System.out.println("Welcome To Mani's World");
		System.out.println("Login Required :");
		System.out.print("Enter User_Name :");
		Scanner s = new Scanner(System.in);
		String user = s.next();
		System.out.print("Enter Password :");
		String pass = s.next();
		AdminDAO admin = new AdminDAOImp();
		Admin adminLogin = admin.adminLogin(user, pass);
		if (adminLogin != null) {
			System.out.println("Login Successfull 😉😉😉");
			VisitorService vs = new VisitorServiceImp();
			boolean b = true;
			while (b) {
				System.out.println("-------------------------------------------------------------------------------");
				System.out.println("Features Available\n1.Save Visitor\n2.Update Visitor\n3.Delete Visitor"
						+ "\n4.Get Visitor By Id\n5.Get Visitor By Contact\n6.Get Visitor By Email\n7.Get All Visitors"
						+ "\n8.Get All Visitor Data Sorted By Name\n9.Get All Visitor Data Sorted By Degree"
						+ "\n10Exit");
				System.out.println("-------------------------------------------------------------------------------");
				System.out.println("Choose one from the Features");
				int choice = s.nextInt();
				Visitor v = new Visitor();
				boolean res = true;
				while (res) {
					switch (choice) {
					case 1:
						System.out.println("Your Choice is - Save Visitor");
						System.out.print("Enter Name :");
						v.setName(s.next());
						System.out.println();
						System.out.print("Enter email :");
						v.setEmail(s.next());
						System.out.println();
						System.out.print("Enter contact :");
						v.setContact(s.next());
						System.out.print("Enter Degree :");
						v.setDegree(s.next());
						System.out.println();
						System.out.print("Enter Stream :");
						v.setStream(s.next());
						System.out.println();
						System.out.print("Enter Percentage :");
						v.setThroughOutPercentage(s.next());
						System.out.println();
						System.out.print("Enter Year of Pass Out :");
						v.setYearOfPassOut(s.nextInt());
						System.out.println();
						System.out.print("Enter Gender :");
						v.setGender(s.next());
						System.out.println();
						System.out.print("Enter Cource :");
						v.setCourse(s.next());
						System.out.println();
						System.out.print("Enter Address :");
						v.setAddress(s.next());
						System.out.println(vs.saveVisitor(v));
						break;
					case 2:
						System.out.println("Your choice is -Update Visitor");
						System.out.print("Enter id Whom You Need to Update :");
						v.setId(s.nextInt());
						System.out.println();
						System.out.print("Enter Name :");
						v.setName(s.next());
						System.out.println();
						System.out.print("Enter email :");
						v.setEmail(s.next());
						System.out.println();
						System.out.print("Enter contact :");
						v.setContact(s.next());
						System.out.print("Enter Degree :");
						v.setDegree(s.next());
						System.out.println();
						System.out.print("Enter Stream :");
						v.setStream(s.next());
						System.out.println();
						System.out.print("Enter Percentage :");
						v.setThroughOutPercentage(s.next());
						System.out.println();
						System.out.print("Enter Year of Pass Out :");
						v.setYearOfPassOut(s.nextInt());
						System.out.println();
						System.out.print("Enter Gender :");
						v.setGender(s.next());
						System.out.println();
						System.out.print("Enter Cource :");
						v.setCourse(s.next());
						System.out.println();
						System.out.print("Enter Address :");
						v.setAddress(s.next());
						vs.updateVisitor(v);
						break;
					case 3:
						System.out.println("Your choice is - Delete visitor :");
						System.out.print("Enter id of Visitor Whom Your willing to Delete :");
						Visitor deleteVisitor = vs.deleteVisitor(s.nextInt());
						System.out.println(deleteVisitor);
						break;
					case 4:
						System.out.println("your Choice is - Get Visitor By Id : ");
						System.out.print("Enter id of visitor to get details :");
						Visitor visitorById = vs.getVisitorById(s.nextInt());
						System.out.println(visitorById);
						break;
					case 5:
						System.out.println("Your Choice is - Get Visitor By Contact :");
						System.out.print("Enter contact Number to get the details of Visitor :");
						Visitor visitorByContact = vs.getVisitorByContact(s.next());
						System.out.println(visitorByContact);
						break;
					case 6:
						System.out.println("Your choice is - Get Visitor By Email :");
						System.out.println("Enter Eamil to get the details of Visitor :");
						Visitor visitorByEmail = vs.getVisitorByEmail(s.next());
						System.out.println(visitorByEmail);
						break;

					case 7:
						System.out.println("Your choice is - Get All Visitors :");
						System.out.println(vs.getAllVisitor());
						break;
					case 8:
						System.out.println("Your choice is - Get All Visitor Data Sorted By Name :");
						System.out.println(vs.getAllVisitorDataSortedByName());
						break;
					case 9:
						System.out.println("Your choice is - Get All Visitor Data Sorted By YearofPassout :");
						System.out.println(vs.getAllVisitorDataSortedByDegree());
						break;
					case 10:
						b = false;
						System.out.println("Signed out Succesfully.......");
						return;
					}
					System.out.println("Do you wish to continue \nIf yes press Y || N Accordingly");
					if (s.next().equalsIgnoreCase("y"))
						res = true;
					else {
						res = false;
					}
				}
			}
		}
	}
}