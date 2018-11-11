package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.model.Registration;
//import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

public class RegistrationJdbc {
	Connection con;
	PreparedStatement ps;
	int i;
	
	public Connection myConnection(){
		//1.load driver
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","System","Newuser123");
			System.out.println("Connection to db..");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("catch connection..");
		} catch (SQLException e) {
			System.out.println("catch connection..2");
			e.printStackTrace();
		}
		return con;
	}
	public int saveData(List<Registration> lst){
		
		Registration r = (Registration)lst.get(0);
		try {
			con=myConnection();
			ps=con.prepareStatement("insert into registration_details values(?,?,?,?,?)");
			ps.setString(1, r.getEmail());
			ps.setString(2, r.getFirstname());
			ps.setString(3, r.getLastname());
			ps.setString(4, r.getPassword());
			ps.setLong(5, r.getContact_no());
			i = ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("test11");
			e.printStackTrace();
		}
		catch(Exception e){
			System.out.println("global.."+e);
		}
		return i;
	}
	
	public boolean validateData(List<Registration> lst) {
		
		Registration r = (Registration)lst.get(0);	
		boolean temp = false;
		try {
			con=myConnection();
			Statement stm =con.createStatement();
			ResultSet rs = stm.executeQuery("select * from registration_details");
			while(rs.next()) {
				if(rs.getString(1).equals(r.getEmail()) && rs.getString(4).equals(r.getPassword())){
					temp = true;
			     }
		}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println(temp);
		return temp;
	}
	
	
/*	public ResultSet displayallPhotos(){
	
			String str="select * from sofa_details";
			con=myConnection();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(str);
			
		
	

	}*/
	public int saveProduct(String type, String file) {
		int i = 0;
		try {
			con=myConnection();
			ps=con.prepareStatement("insert into sofa_details(id,type,photo) values(sofa_seq.nextVal, ?, ?)");
			ps.setString(1, type);
			ps.setString(2, file);
			i = ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return i;
	}
}