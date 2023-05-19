package dao;

import model.Employee;


import java.sql.*;
import model.Employee;
import model.UserLogin;
import java.util.Random;

public class Login {
	
	public UserLogin loginVerify(Employee employee) throws ClassNotFoundException {
		String query =  "SELECT username, password WHERE username = ? and password = ?;";
		
        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager
	            .getConnection("jdbc:mysql://localhost:3306/employees", "root", "")){
        	
        	Statement st = connection.createStatement();
        	ResultSet rs = st.executeQuery(query);
        	
        	Employee emp = new Employee();
        	UserLogin ul = new UserLogin();
        	Random gerador = new Random();
            while (rs.next()) {
            	
            	emp.setUsername(rs.getString("username"));
            	emp.setPassword(rs.getString("password"));
            	ul.setEmployee(emp);
            	ul.setToken(gerador.nextInt());
            	
            	return ul;
            }
        	
        } catch (SQLException e) {
        	return null;
        }
        return null;
	}
}
