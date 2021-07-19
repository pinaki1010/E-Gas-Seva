package com.bean;

public class AdminBean {
private String name,password;

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public boolean validate(){
	if(name.equals("JAVA")&& password.equals("JAVA")){
		return true;
	}else{
		return false;
		

}
}
}
