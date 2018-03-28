package com.zzti.market.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

public class AESUtil {
	/**
	 * 功能：生成AES秘钥并写入指定文件中
	 * 
	 * @param filePath
	 *            文件夹绝对路径，必须是已存在文件夹
	 * @throws Exception
	 */
	public static void genAESKeyPair(String filePath) throws Exception {
		// keySpec 生成对称密钥
		KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
		keyGenerator.init(128);
		SecretKey secretKey = keyGenerator.generateKey();
		SecretKeySpec keySpec = new SecretKeySpec(secretKey.getEncoded(), "AES");

		try {
			String publicKeyString = Base64.encodeBase64String(keySpec.getEncoded());
			System.out.println(publicKeyString);

			FileWriter pubfw = new FileWriter(filePath + "AESKey.key");
			BufferedWriter pubbw = new BufferedWriter(pubfw);
			pubbw.write(publicKeyString);

			pubbw.flush();
			pubbw.close();
			pubfw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取签名
	 * 
	 * @param data
	 *            要加签的数据
	 * @param MD5key
	 *            加签时使用的key
	 * @return 签名字符串
	 * @throws Exception
	 */
	public static String getSignature(String data, String MD5key){
		byte[] b;
		data = data + "|" + MD5key; // data与key一块签名
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			b = md.digest(data.getBytes("UTF-8")); // md5签名
		} catch (Exception e) {
			// 记录请求信息
			e.printStackTrace();
			return "md5-Exception";
		}
		return Base64.encodeBase64String(b); // base64转码
	}

	/**
	 * AES加密
	 * 
	 * @param plainTextData
	 *            要加密的数据
	 * @param key
	 *            加密时使用的key
	 * @return 返回加密后的数据
	 * @throws Exception
	 */
	public static String encryptAES(String plainTextData, String key){
		byte[] encryptedData={};
		// 密钥
		try {
			KeyGenerator kgen = KeyGenerator.getInstance("AES");
			SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
			secureRandom.setSeed(key.getBytes());
			kgen.init(128, secureRandom);

			SecretKey skey = kgen.generateKey();
			byte[] raw = skey.getEncoded();
			SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");

			// 加密数据
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
			encryptedData = cipher.doFinal(plainTextData.getBytes("UTF-8"));
		}catch (Exception e){

		}


		return Base64.encodeBase64String(encryptedData); // base64转码
	}

	/**
	 * AES解密
	 * 
	 * @param encryptedData
	 *            要解密的数据
	 * @param key
	 *            解密所使用的key
	 * @return 解密后的数据
	 * @throws Exception
	 */
	public static String decryptAES(String encryptedData, String key) throws Exception {
		// 密钥
		KeyGenerator kgen = KeyGenerator.getInstance("AES");
		SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
		secureRandom.setSeed(key.getBytes());
		kgen.init(128, secureRandom);
		SecretKey skey = kgen.generateKey();
		byte[] raw = skey.getEncoded();
		SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");

		// 解密数据
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.DECRYPT_MODE, skeySpec);
		byte[] decryptedData = cipher.doFinal(Base64.decodeBase64(encryptedData));

		return new String(decryptedData, "UTF-8");
	}

	/**
	 * 验签
	 * 
	 * @param encryptedSignature MD5加签的数据
	 * @param plainTextData DATA明文
	 * @param key MD5 key
	 * @return
	 * @throws Exception
	 */
	public static boolean verify(String encryptedSignature, String plainTextData, String key) {
		String signature = getSignature(plainTextData, key);
        
		if (encryptedSignature.equals(signature)) {
			return true;
		}

		return false;
	}
}
