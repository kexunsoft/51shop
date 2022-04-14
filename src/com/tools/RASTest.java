package com.tools;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPublicKey;

import javax.crypto.Cipher;
import org.apache.commons.codec.binary.Base64;
public class RASTest {
	
	public static  KeyPair  keyPair=init();
	public static String getPublicKey() {
	return	Base64.encodeBase64String(((RSAPublicKey)RASTest.keyPair.getPublic()).getEncoded());
	}
	public static KeyPair init() {
		//初始化
				KeyPairGenerator keyPairGenerator=null;
				try {
					keyPairGenerator = KeyPairGenerator.getInstance("RSA");
				} catch (NoSuchAlgorithmException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				keyPairGenerator.initialize(512);
				KeyPair keyPair = keyPairGenerator.generateKeyPair();
				
				return keyPair;
	}
//	public static String jiami(String str) throws Exception {
//		//加密
//				
//				Cipher cipher =Cipher.getInstance("RSA");
//				cipher.init(Cipher.ENCRYPT_MODE,keyPair.getPublic());
//				
//				byte[] doFinal = cipher.doFinal(str.getBytes());
//				System.out.println("公钥加密:"+Base64.encodeBase64String(doFinal));
//				
//				return Base64.encodeBase64String(doFinal);
//	}
	public static String jiemi(String str)  {
		
		//解密
		byte[] doFinal2=null;
				try {
					Cipher cipher =Cipher.getInstance("RSA");
					cipher.init(Cipher.DECRYPT_MODE,keyPair.getPrivate());
					doFinal2 = cipher.doFinal(Base64.decodeBase64(str.getBytes()));
				} catch (Exception e) {

					System.err.println("解密错误:公钥已过期");
					
				}
				return	new String(doFinal2);	
	}
}
