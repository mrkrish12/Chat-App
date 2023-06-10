package com.krishna.chatapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import static com.krishna.chatapp.utils.ConfigReader.getValue;

public interface Commondao {
    public static Connection createConnection() throws ClassNotFoundException, SQLException {
    	Class.forName(getValue("DRIVER"));
    	//step 2  making connection 
    	final String Connection_String =getValue("CONNECTION_URL");
    	final String User_ID =getValue("USERID");
    final String PASSWORD =getValue("PASSWORD");
    	Connection con = DriverManager.getConnection(Connection_String,User_ID,PASSWORD);
    	if(con !=null)
    	{
    		System.out.println("Connection done.....");
    		
    	}
    	return con;
    }
}
