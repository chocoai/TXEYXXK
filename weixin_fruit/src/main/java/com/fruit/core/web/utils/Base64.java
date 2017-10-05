package com.fruit.core.web.utils;

import sun.misc.BASE64Encoder;

import java.io.IOException;

import sun.misc.BASE64Decoder;

@SuppressWarnings("restriction")
public class Base64 {
	/**
	 * BASE64解密
	 * 
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static byte[] decryptBASE64(String key) {
		try {
			return (new BASE64Decoder()).decodeBuffer(key);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * BASE64加密
	 * 
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static String encryptBASE64(byte[] key) {
		return (new BASE64Encoder()).encodeBuffer(key);
	}

	public static void main(String[] args) {
		System.out.println(encryptBASE64("cinwell".getBytes()));
		System.out.println(Bundle.convUTF8(decryptBASE64("root123456"), "utf-8"));

	}
}