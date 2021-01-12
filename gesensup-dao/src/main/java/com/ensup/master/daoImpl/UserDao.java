package com.ensup.master.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ensup.master.dao.IUserDao;
import com.ensup.master.metier.Course;
import com.ensup.master.metier.Student;
import com.ensup.master.metier.User;

public class UserDao implements IUserDao {

	
	private String url = "jdbc:mysql://localhost/dougschool?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private String sql_login = "root";
	private String sql_password = "";
	
	
	/**
	 * 
	 * @param login
	 * @param password
	 * @return
	 */	 
	@Override
	public User getUser(String login, String password) {
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		User user = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection(url, sql_login, sql_password);
			
			st = cn.createStatement();
			
			String sql = "SELECT * FROM `user` WHERE `login` = '"+login+"' and `password` = '"+password+"' ";
		
			rs = st.executeQuery(sql);
			
			if(rs.next()) {
				user = new User(rs.getInt("id"), rs.getString("login"), rs.getString("password"), rs.getString("profil"));
			}
			
			cn.close();
			st.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	
}
