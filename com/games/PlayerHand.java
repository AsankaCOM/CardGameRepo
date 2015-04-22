package com.games;

import java.util.Arrays;

public class PlayerHand implements Comparable<PlayerHand> {
	private int order;
	private Card[] cards;

	PlayerHand(int handSize, int order) {
		this.order = order;
		cards = new Card[handSize];
	}

	public Rank evaluateHand() {
		for (Rank rank : Rank.values()) {
			if (rank.matches(cards))
				return rank;
		}

		/* imply there is not a matching hand */
		return null;
	}

	@Override
	public int compareTo(PlayerHand playerHand) {
		int d = this.evaluateHand().compareTo(playerHand.evaluateHand());
		if (d == 0) {
			Arrays.sort(this.cards);
			Arrays.sort(playerHand.cards);
			short rank1 = this.cards[0].getRank();
			short rank2 = playerHand.cards[0].getRank();

			if (rank2 > rank1) {
				return 1;
			}
			if (rank2 < rank1) {
				return -1;
			}

			return 0;
		}

		return d;
	}

	@Override
	public boolean equals(Object obj) {
		boolean b = true;

		if (obj instanceof PlayerHand) {
			PlayerHand playerHand = (PlayerHand) obj;

			Card[] cards = playerHand.getCards();

			if (cards != null && this.cards != null) {
				if (cards.length != this.cards.length)
					b = false;
				else
					for (int i = 0; i < this.cards.length; i++) {
						if (!this.cards[i].equals(cards[i])) {
							b = false;
						}
					}
			} else {
				b = false;
			}
		} else {
			b = false;
		}

		return b;
	}

	public Card[] getCards() {
		return cards;
	}

	public int getOrder() {
		return order;
	}

	public @Override
	String toString() {
		return "Hand-" + order + "(" + evaluateHand().description + ")";
	}
}
