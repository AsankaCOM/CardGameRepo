package com.games;

import static java.lang.System.out;


public class CardGame {

	public static void printTheCurrentGame(Deck d, Dealer dealer) {

		for (PlayerHand hand : dealer.getPlayerHands()) {
			System.out.println(hand + " has the following cards: ");
			for (Card card : hand.getCards()) {
				System.out.println(card);
			}
			out.println();
		}
	}

	public static void main(String[] args) {
		int players;

		if (args.length == 1) {
			try {
			 players = Integer.parseInt(args[0]);
			} catch (NumberFormatException e) {
				out.println("Invalid input - " + args[0]);
				return;
			}
			if (players < 2) {
				out.println("we need at least 2 players !");
				return;
			}
		} else {
			players = 2;
		}

		Deck deck = new Deck();

		Dealer dealer = new Dealer(deck, players);

		printTheCurrentGame(deck, dealer);

		out.println(dealer.announceResults());
	}
}