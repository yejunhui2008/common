package com.yejh.design.decorator;

public class Change implements TheGreaterSage {

	private TheGreaterSage sage;

	public Change(TheGreaterSage sage) {
		this.sage = sage;
	}

	@Override
	public void move() {
		sage.move();
	}

}
