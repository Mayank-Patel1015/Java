// package com.hackathon.dekofcards;

import java.util.Random;
import java.util.ArrayList;

public class TestDeck {

	public static void main(String[] args) {

		Deck myDeck = new Deck();
		for (Card card : myDeck.getCards()) {
			// card.showCard();
		}

		while(true){
			Deck playersHand = new Deck();
			playersHand.setCards(new ArrayList<Card>());
			Deck pcHand = new Deck();
			pcHand.setCards(new ArrayList<Card>());

			int pcCardInd = 0;
			int playerCardInd = 0;
			pcCardInd = new Random().nextInt(0,myDeck.getCards().size());
			pcHand.getCards().add(myDeck.getCards().remove(pcCardInd));
			playerCardInd = new Random().nextInt(0,myDeck.getCards().size());
			playersHand.getCards().add(myDeck.getCards().remove(playerCardInd));

			// pcCardInd = new Random().nextInt(0,myDeck.getCards().size());
			// pcHand.getCards().add(myDeck.getCards().remove(pcCardInd));
			playerCardInd = new Random().nextInt(0,myDeck.getCards().size());
			playersHand.getCards().add(myDeck.getCards().remove(playerCardInd));

			System.out.println("PC hand: ");
			pcHand.printCards();
			System.out.println("Score is: " + pcHand.countCards());
			System.out.println("Players hand: ");
			playersHand.printCards();
			System.out.println("Score is: " + playersHand.countCards());

			while(true){
				System.out.println("Want to Hit? Hit h. Want to stand? Enter the letter s.");
				String hit = System.console().readLine();
				if(hit.equals("h")){
					playerCardInd = new Random().nextInt(0,myDeck.getCards().size());
					playersHand.getCards().add(myDeck.getCards().remove(playerCardInd));
				} else if(hit.equals("s")){
					break;
				}

				playersHand.printCards();
				System.out.println(playersHand.countCards());

				if(playersHand.countCards() > 21) {
					System.out.println("ur the biggest loser ever absolute bafoon.");
					break;
				}
				if(playersHand.countCards() == 21) {
					break;
				}
			}
			while(pcHand.countCards() < 16){
				System.out.println("dealers turn: ");
				pcCardInd = new Random().nextInt(0,myDeck.getCards().size());
				pcHand.getCards().add(myDeck.getCards().remove(pcCardInd));
				pcHand.printCards();
				System.out.println(pcHand.countCards());
			}
			if(pcHand.countCards() > playersHand.countCards() || playersHand.countCards() > 21){
				System.out.println("ur the biggest loser ever absolute bafoon.");
			} else if (pcHand.countCards() == playersHand.countCards()){
				System.out.println("Nice try but you get no money!");
			} else {
				System.out.println("You finally won one!");
			}
			System.out.println("Want to play again? Hit Enter. Want to quit? Enter the letter q.");
			String quit = System.console().readLine();
			if(quit.equals("q")){
				break;
			}
		}
	}
}