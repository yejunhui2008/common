package com.yejh.code;

import java.io.UnsupportedEncodingException;

public class CodeConvert {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String str = "运@测";
		
		/*************UTF-8转换GBK*****************/
		str = new String(str.getBytes("UTF-8"), "GBK");
		System.out.println(str);//乱码

		str = new String(str.getBytes("GBK"), "UTF-8");
		System.out.println(str);//看str字符串为3的倍数被2整除不乱码，否则乱码，另外ascii的64之后第一位不乱码，目前无法解释

		/*************GBK转换UTF-8*****************/
//		str = new String(str.getBytes("GBK"), "UTF-8");
//		System.out.println(str);//乱码，UTF-8自动补一位
//		
//		str = new String(str.getBytes("UTF-8"), "GBK");
//		System.out.println(str);//乱码
	}
}
