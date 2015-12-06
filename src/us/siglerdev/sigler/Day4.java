package us.siglerdev.sigler;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Day4 {
	public Thread t1 = null, t2 = null;
	public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException{
		long start = System.currentTimeMillis();
		MessageDigest m = null;
		try {
			m = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String KEY = "yzbqklnj";
		for (int i = 1; i < Integer.MAX_VALUE; i+=2){
			String temp = KEY + i;
			m.update(temp.getBytes(),0,temp.length());
			String val = toHex(m.digest());
			if (val.startsWith("00000")){
				System.out.println("\n\n\nMD5: "+ temp + " is the full MD5 value\n"+val);
				break;
			}
		}
		System.out.println("\nTime: " + (System.currentTimeMillis()-start));
	}
	
	private static final char[] HEX_DIGITS = "0123456789ABCDEF".toCharArray();
	public static String toHex(byte[] data) {
		char[] chars = new char[data.length * 2];
		for (int i = 0; i < data.length; i++) {
			chars[i * 2] = HEX_DIGITS[(data[i] >> 4) & 0xf];
			chars[i * 2 + 1] = HEX_DIGITS[data[i] & 0xf];
		}
		return new String(chars);
	}
}
