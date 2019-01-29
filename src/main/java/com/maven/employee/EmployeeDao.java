package com.maven.employee;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

//Data Access Object
public class EmployeeDao {
	public void  add(Employee emp) throws DataAccessException{
		Connection conn = null;
		PreparedStatement pstmt = null; //Precompiled SQL Comments
		
		try {
			
			//Read the dev-db.properties file for the variables
			//Why not FileInputStream is = new FileInputStream("dev-db.properties")
			
			//How to change the properties file dynamically at runtime?
			//The file is loaded only once in the memory
			InputStream is = this.getClass().getClassLoader().getResourceAsStream("dev-db.properties");
			Properties dbProperties = new Properties(); //Loading the properties using Properties Class
			//The Properties class uses HashMap for storing the data
			
			//No error because the exception is caught below specifically as IOException
			dbProperties.load(is);
			
			String driverClassName = dbProperties.getProperty("driverClassName");
			String url = dbProperties.getProperty("url");
			String username = dbProperties.getProperty("username");
			String password = dbProperties.getProperty("password");
			
			Class.forName(driverClassName);
			conn = DriverManager.getConnection(url,username,password);

			//Syntax below remains same for update and delete
			pstmt = conn.prepareStatement("insert into emp2 values(?,?,?)"); //To add value in the runtime '?' is added inside values
			
			//Syntax for inserting data "pstmt.setString(column_no,object.method())"
			pstmt.setString (1, emp.getName());
			pstmt.setString(2, emp.getSalary());
			pstmt.setInt(3, emp.getEmpNo());
			
			pstmt.executeUpdate(); //Inserting data in table and updating table
			
			System.out.println("Data inserted");
		}
		catch(ClassNotFoundException | IOException | SQLException e) {
			throw new DataAccessException ("Data cannot be Accessed", e);
		}

		finally {
			try {
				pstmt.close();
			}catch(Exception e){
				
			}
			try {
				conn.close();
			}
			catch(Exception e) {
				
			}
			
		}
	}

	public void add(int empno, String name, String salary) {
		// TODO Auto-generated method stub
		
	}
}