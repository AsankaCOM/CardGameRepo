package com.games;

import static java.lang.System.out;
import java.util.ArrayList;

public class Deck {
    private ArrayList<Card> cards;
    
    Deck() {
        out.println("---- The deck has been shuffled ----");
        out.println();
        cards = new ArrayList<Card>();
  
       for (short suit=0; suit<=3; suit++) {
            for (short rank=0; rank<=12; rank++) {
               cards.add(new Card(suit,rank));
            }
       }
    }

    public Card dealFromDeck() {
        return cards.remove( 0 );
    }

    public int getTotalCards() {
        return cards.size();   
    } 

    public Card showTopDeckCard(Deck d) {
        Card card;
        card = d.cards.get(0);
        return card;
    }

	public ArrayList<Card> getCards() {
		return cards;
	}

	public void setCards(ArrayList<Card> cards) {
		this.cards = cards;
	}
}