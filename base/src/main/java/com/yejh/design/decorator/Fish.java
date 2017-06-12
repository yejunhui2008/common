package com.yejh.design.decorator;

public class Fish extends Change {

	public Fish(TheGreaterSage sage) {
		super(sage);
	}

	@Override
	public void move() {
		System.out.println("Fish Move");
	}
}
