package com.yejh.list;

import com.google.common.collect.ImmutableList;

public class ImmutableListTest {

	public static void main(String[] args) {
		ImmutableList<String> imlist = ImmutableList.of("a", "b", "c");
		imlist.add("d");//java.lang.UnsupportedOperationException
		for (String s : imlist) {
			System.out.println(s);
		}
	}

}
