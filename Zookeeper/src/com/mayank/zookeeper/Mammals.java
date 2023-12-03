package com.mayank.zookeeper;

public abstract class Mammals {
	protected int energy; 
	
	public Mammals() {
		this.energy = 100;
	}
	
	public Mammals(int energy) {
		this.energy = energy;
	}
	
	public void displayEnergy() {
		System.out.println("Mammal has " + this.energy + " energy left");
	}
}
