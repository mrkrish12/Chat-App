package com.krishna.chatapp.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public interface Encryption {
 
public static String passwordEncrypt(String plainPasswprd) throws NoSuchAlgorithmException
	{
		String encryptedPassword = null;
	MessageDigest messageDigesr	= MessageDigest.getInstance("MD5");
	messageDigesr.update(plainPasswprd.getBytes());
	byte [] encrypt = messageDigesr.digest();
	System.out.println(encrypt);
	StringBuffer sb = new StringBuffer();
	for(byte b : encrypt)
	{
		sb.append(b);
	}
	encryptedPassword = sb.toString();
//	System.out.println("Encrypted pass" +encryptedPassword);
		return encryptedPassword;
	}
}
