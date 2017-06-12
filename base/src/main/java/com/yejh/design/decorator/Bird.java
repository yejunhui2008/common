package com.yejh.design.decorator;

public class Bird extends Change {

	public Bird(TheGreaterSage sage) {
		super(sage);
	}

	@Override
	public void move() {
		System.out.println("Bird Move");
	}
}
