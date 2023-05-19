package model;

import model.Employee;

public class UserLogin {
	int token;
	Employee employee;
	
	
	public int getToken() {
		return token;
	}
	public void setToken(int token) {
		this.token = token;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}
