package com.yejh.jdk8.lambda;

import java.util.Arrays;
import java.util.List;

public class ForEashTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = Arrays.asList("123", "45634", "7892", "abch", "sdfhrthj", "mvkd");
//		list.stream().forEach(e -> {
//			if (e.length() >= 5) {
//				return;
//			}
//			System.out.println(e);
//		});

		list.stream().filter(e -> e.length() < 5).forEach(e -> System.out.println(e));
	}

}
