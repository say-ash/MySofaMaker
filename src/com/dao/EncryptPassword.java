package com.dao;
/*Please don't implement your current plans, instead you should use a MessageDigest to accomplish this. Apply a one way cryptographic hash function to the user's password (e.g. one of SHA-256, SHA-384, and SHA-512 [and there are others]) and a SALT to prevent rainbow table based attacks. Finally, for password resets, just replace the current password hash.
@Ellios Thank you very much.How can i decrypt this hashvalue? – mekafe Dec 30 '13 at 2:21
3
@mekafe You don't. That's the entire point. The user is the only one who can provide their "correct" password. Even if someone gets a copy of your password database, they cannot determine another user's password. – Elliott Frisch Dec 30 '13 at 2:25 
oh,but i need value of password for example in login.I need to check the password.How will i do this? – mekafe Dec 30 '13 at 2:28
1
@mekafe The user gives you their password and you hash it again; if the hashed value matches the value stored in the database it's correct. Otherwise, it's incorrect. To change the password, verify the user's identity some other way and then replace the password hash. – Elliott Frisch Dec 30 '13 at 2:30
@mekafe That's why I hashed "Hello" twice, to show you that you'll get the same output with the same input... – Elliott Frisch Dec 30 '13 at 2:31
yep,i got it.I'm trying now. – mekafe Dec 30 '13 at 2:36
Worked,big thanks to you. – mekafe Dec 30 '13 at 2:40 
This works if your system is the one that does the authentication, but not where you need to store a password in the DB to authenticate against a third-party. – Glenn Lawrence Mar 26 '15 at 3:18
*/


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptPassword {
	// We need a bytesToHex method first. So, from -
	// http://stackoverflow.com/a/9855338/2970947
	final protected static char[] hexArray = "0123456789ABCDEF"
	    .toCharArray();

	public static String bytesToHex(byte[] bytes) {
	  char[] hexChars = new char[bytes.length * 2];
	  int v;
	  for (int j = 0; j < bytes.length; j++) {
	    v = bytes[j] & 0xFF;
	    hexChars[j * 2] = hexArray[v >>> 4];
	    hexChars[j * 2 + 1] = hexArray[v & 0x0F];
	  }
	  return new String(hexChars);
	}

	// Change this to something else.
	private static String SALT = "123456";

	// A password hashing method.
	public String hashPassword(String in) {
	  try {
	    MessageDigest md = MessageDigest
	        .getInstance("SHA-256");
	    md.update(SALT.getBytes());        // <-- Prepend SALT.
	    md.update(in.getBytes());
	    // md.update(SALT.getBytes());     // <-- Or, append SALT.

	    byte[] out = md.digest();
	    return bytesToHex(out);            // <-- Return the Hex Hash.
	  } catch (NoSuchAlgorithmException e) {
	    e.printStackTrace();
	  }
	  return "";
	}
}
