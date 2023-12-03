// package com.hackathon.dekofcards;

import java.util.ArrayList;

public class Deck {

    private ArrayList<Card> cards;

    public Deck() {
        this.cards = new ArrayList<Card>();

        // Populate the cards list -- loop to 52
        for (String name : new String[] { "Hearts", "Clubs", "Diamonds", "Spades" }) {
            for (Integer rank = 1; rank <= 13; rank++) {
                this.cards.add(new Card(name, rank));
            }
        }
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public void printCards() {
        for( Card card: this.cards){
			card.showCard();
		}
    }

    public int countCards() {
        int answer = 0;
        for( Card card: this.cards){
            int rank = card.getRank();
            if(rank > 10){
                rank = 10;
            }
            if( rank == 1){
                rank = 11;
            }
			answer += rank;
		}
        // A A 9 = 21        11 + 1 + 9 = 21
        // A A 10 = 32 - 10 - 10 = 12
        if(answer > 21){
            for( Card card: this.cards){
                int rank = card.getRank();
                if(rank == 1){
                    answer -= 10;
                }
                if(answer <= 21) {
                    break;
                }
            }
        }
        return answer;
    }

}
