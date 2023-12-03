package com.mayank.zookeeper;

public class Test {
	public static void main(String[] args) {		
		Gorilla harambe = new Gorilla();
		harambe.displayEnergy();	
		// Gorilla throw things 3 times, eat bananas twice, climb once
		harambe.throwSomething();
		harambe.throwSomething();
		harambe.throwSomething();
		harambe.eatBananas();
		harambe.eatBananas();
		harambe.climb();
		harambe.displayEnergy();
		
		System.out.println("Bat tests incoming!");
		Bat bat1 = new Bat();
		bat1.displayEnergy();
		// The bat should be tested by attacking three towns, eating two humans, flying twice, and then displaying its energy.
		bat1.attackTown();
		bat1.attackTown();
		bat1.attackTown();
		bat1.eatHumans();
		bat1.eatHumans();
		bat1.fly();
		bat1.fly();
		bat1.displayEnergy();
		
	}
}
