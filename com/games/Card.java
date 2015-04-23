package com.games;

public class Card implements Comparable<Card> {
	private short rank;
	private short suit;
	public static String[] suits = { "Hearts", "Spades", "Diamonds", "Clubs" };
	public static String[] ranks = { "2", "3", "4", "5", "6", "7", "8", "9",
			"10", "Jack", "Queen", "King", "Ace" };

	public static String rankAsString(int __rank) {
		return ranks[__rank];
	}

	Card(short suit, short rank) {
		this.rank = rank;
		this.suit = suit;
	}

	@Override
	public String toString() {
		return ranks[rank] + " of " + suits[suit];
	}

	public short getRank() {
		return rank;
	}

	public short getSuit() {
		return suit;
	}

        //compare 2 cards  
	public int compareTo(Card card) {
		short rank = card.getRank();

		if (rank > this.rank) {
			return 1;
		}

		if (rank < this.rank) {
			return -1;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Card) {
			Card card = (Card) obj;
			if (card.getRank() == this.rank && card.getSuit() == this.suit) {
				return true;
			}
		}
		return false;
	}
}
