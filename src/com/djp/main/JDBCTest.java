package com.djp.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCTest {
	public static void main(String[] args) throws Exception {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			 Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatis?characterEncoding=utf8", "root", "root");
			String sql = "select * from t_user where id=?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, 1);
			rs = stmt.executeQuery();
			if(rs.next()){
				System.out.println(rs.getString("pwd"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			rs.close();stmt.close();con.close();
		}
	}
}
