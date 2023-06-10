package com.krishna.chatapp.dao;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.krishna.chatapp.dto.Userdto;
import com.krishna.chatapp.utils.Encryption;

// user pa crud operation ka liya
public class Userdao {

	public boolean isLogin(Userdto userdto) throws SQLException, ClassNotFoundException,Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		final String SQL = "select userid from users where userid=? and password =?";
		try {
			 con = Commondao.createConnection();
			 pstmt = con.prepareStatement(SQL);
			 pstmt.setString(1, userdto.getUserid());
			String encyptedpsw =   Encryption.passwordEncrypt(new String(userdto.getPassword()));
			 pstmt.setString(2,encyptedpsw);
			rs =  pstmt.executeQuery();
			return rs.next();
		}
		finally {
			if(rs!=null)
			{
				rs.close();
			}
			if(pstmt!=null)
			{
				pstmt.close();
			}
			if(con!=null)
			{
				con.close();
			}
			
		}
	}
	
	
	public int add(Userdto userdto) throws ClassNotFoundException, SQLException,Exception{
		System.out.println("rec " +userdto.getUserid()+" "+userdto.getPassword());
		Connection connection = null;
		Statement stmt = null;
		try {
		connection = Commondao.createConnection();
		stmt = connection.createStatement();
	int record =stmt.executeUpdate("insert into users(userid,password) values('"+userdto.getUserid()+"' ,'"+Encryption.passwordEncrypt(new String(userdto.getPassword()))+"')");
	return record;
		}
		finally {
			if(stmt!=null)
			{
		stmt.close();}
			if(connection!=null)
			{
		connection.close();}}
	}
}
