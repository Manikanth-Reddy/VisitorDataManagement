package com.mani.visitordatamangement.dto;

public class Visitor {
	private int id;
	private String name;
	private String email;
	private String degree;
	private String stream;
	private String throughOutPercentage;
	private int yearOfPassOut;
	private String gender;
	private String address;
	private String contact;
	private String course;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getStream() {
		return stream;
	}

	public void setStream(String stream) {
		this.stream = stream;
	}

	public String getThroughOutPercentage() {
		return throughOutPercentage;
	}

	public void setThroughOutPercentage(String throughOutPercentage) {
		this.throughOutPercentage = throughOutPercentage;
	}

	public int getYearOfPassOut() {
		return yearOfPassOut;
	}

	public void setYearOfPassOut(int yearOfPassOut) {
		this.yearOfPassOut = yearOfPassOut;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "Visitor [id=" + id + ", name=" + name + ", email=" + email + ", degree=" + degree + ", stream=" + stream
				+ ", throughOutPercentage=" + throughOutPercentage + ", yearOfPassOut=" + yearOfPassOut + ", gender="
				+ gender + ", address=" + address + ", course=" + course + "]";
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
	
}
