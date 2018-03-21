package com.wap.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Course Dao
 * 
 * @author Carlton Ellis
 * @date 2018-03-19
 */

public class Encrypt {
	public static String HashPassword(String passwordToHash) {// Password Hashing
		/*
		 * Method taken from:
		 * https://howtodoinjava.com/security/how-to-generate-secure-password-hash-md5-
		 * sha-pbkdf2-bcrypt-examples/
		 */
		passwordToHash += "Salt@73@#$_";
		String generatedPassword = null;
		try {
			// Create MessageDigest instance for MD5
			MessageDigest md = MessageDigest.getInstance("MD5");
			// Add password bytes to digest
			md.update(passwordToHash.getBytes());
			// Get the hash's bytes
			byte[] bytes = md.digest();
			// This bytes[] has bytes in decimal format;
			// Convert it to hexadecimal format
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			// Get complete hashed password in hex format
			generatedPassword = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		System.out.println(generatedPassword);
		return generatedPassword;
	}

}
