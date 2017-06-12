package com.yejh.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServiceLoader<IA> spiLoader = ServiceLoader.load(IA.class);
		Iterator<IA> it = spiLoader.iterator();
		while (it.hasNext()) {
			IA ia = (IA) it.next();
			ia.say();
		}
	}

}
