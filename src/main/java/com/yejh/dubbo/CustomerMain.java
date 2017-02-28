package com.yejh.dubbo;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CustomerMain {
	public static void main(String[] args) {
		// 初始化Spring
		ApplicationContext ctx = new ClassPathXmlApplicationContext("dubbo/spring-consumer.xml");
		DubboService dubboService = (DubboService) ctx.getBean("dubboService"); // 获取远程服务代理
		File f = new File("E:send.log");
		InputStream in;
		try {
			in = new FileInputStream(f);
			byte b[] = new byte[1024];
			int len = 0;
			int temp = 0; //所有读取的内容都使用temp接收   
			while ((temp = in.read()) != -1) { //当没有读取完时，继续读取   
				b[len] = (byte) temp;
				len++;
			}
			in.close();
			dubboService.sendFile("", in);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
