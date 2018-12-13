package com.mycompany.shelter.jcaptcha;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class test {
public static void main(String[] args) {
	 String hashAlgorithmName = "MD5";
     String credentials = "111";
     int hashIterations = 1024;
     ByteSource credentialsSalt = ByteSource.Util.bytes("18211111111");
     Object obj = new SimpleHash(hashAlgorithmName, credentials, credentialsSalt, hashIterations);
     System.out.println(obj);
}
}
