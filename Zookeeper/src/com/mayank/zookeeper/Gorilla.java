package com.mayank.zookeeper;

public class Gorilla extends Mammals{
	public Gorilla() {
		super();
	}
	public void throwSomething(){
		this.energy -= 5;
		System.out.println("Gorilla threw something");
	}
	public void eatBananas() {
		this.energy += 10;
		System.out.println("Gorilla ate a banana");
	}
	public void climb() {
		this.energy -= 10;
		System.out.println("Gorilla climbed");
	}
}
