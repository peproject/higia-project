package start.project.higia.utils;

import java.math.BigInteger;
import java.security.MessageDigest;

public class Util {
public static String md5(String password) {
		
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("md5");
			BigInteger hash = new BigInteger(1, messageDigest.digest(password.getBytes()));
			return hash.toString(16);
		} catch (Exception e) {
			return "";
			
		}
	}
}
