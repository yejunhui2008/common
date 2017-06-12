package com.yejh.design.decorator;

public class Client {

	public static void main(String[] args) {
		TheGreaterSage sage = new Monkey();
		sage.move();
		
		TheGreaterSage bird = new Bird(sage);
		bird.move();
		
		TheGreaterSage fish = new Fish(bird);
		fish.move();
	}

}
