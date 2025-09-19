package com.restassured.postrequestbody;

public class POJO_POSTRequest {
	
	
	String localtion;
	String phone;
	String course[];
	
	
	String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocaltion() {
		return localtion;
	}
	public void setLocaltion(String localtion) {
		this.localtion = localtion;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String[] getCourse() {
		return course;
	}
	public void setCourse(String[] course) {
		this.course = course;
	}
	

}
