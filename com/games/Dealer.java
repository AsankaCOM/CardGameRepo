package com.games;

import java.util.Arrays;
import java.util.Collections;

public class Dealer {
	private PlayerHand[] playerHands;
	public static int HAND_SIZE = 2;

	Dealer(Deck deck, int players) {

		shuffle(deck);

		playerHands = new PlayerHand[players];

		for (int i = 0; i < players; i++) {
			playerHands[i] = new PlayerHand(HAND_SIZE, (i + 1));
		}

		for (int x = 0; x < HAND_SIZE; x++) {
			for (int y = 0; y < players; y++) {
				playerHands[y].getCards()[x] = deck.dealFromDeck();
			}
		}
	}

	protected void shuffle(Deck deck) {
		Collections.shuffle(deck.getCards());
	}

	void displayAll(int round) {

		for (PlayerHand hand : playerHands) {
			System.out.println("Hand " + hand + " has the following cards: ");
			for (Card card : hand.getCards()) {
				System.out.println(card);
			}
		}
	}

	public String announceResults() {
		Arrays.sort(playerHands);

		if (playerHands[0].evaluateHand() == playerHands[1].evaluateHand()
				&& playerHands[0].getCards()[0].getRank() == playerHands[1]
						.getCards()[0].getRank()) {
			return "It's a draw";
		} else {
			return "Winning hand : " + getPlayerHands()[0];
		}
	}

	public PlayerHand[] getPlayerHands() {
		return playerHands;
	}

	public int getHandSize() {
		return HAND_SIZE;
	}
}