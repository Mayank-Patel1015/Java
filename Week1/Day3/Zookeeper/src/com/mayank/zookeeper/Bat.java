package com.mayank.zookeeper;

public class Bat extends Mammals {
	public Bat() {
		super(300);
	}
	public void fly() {
		this.energy -= 50;
		System.out.println("The bat took to the skies.");
	}
	public void eatHumans() {
		this.energy += 25;
		System.out.println("The bat ate a human!");
	}
	public void attackTown() {
		this.energy -= 100;
		System.out.println("The bat attacked the town and kill 25 people!");
	}
}
