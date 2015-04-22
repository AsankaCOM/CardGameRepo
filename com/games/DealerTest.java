package com.games;

import static java.lang.System.out;
import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;

public class DealerTest {

	@Test
	public void testAnnounceResults_Draw() {

		TestDeck deck = new TestDeck();

		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(PlayerHandTest.getCard("Hearts", "3"));
		cards.add(PlayerHandTest.getCard("Clubs", "10"));
		cards.add(PlayerHandTest.getCard("Hearts", "Queen"));
		cards.add(PlayerHandTest.getCard("Clubs", "Queen"));

		deck.setCards(cards);

		Dealer dealer = new Dealer(deck, 2) {
			protected void shuffle(Deck deck) {
				// do nothing
			}
		};

		printPalyerHands(dealer);

		String result = dealer.announceResults();
		out.println(result);
		assertEquals("It's a draw", result);
	}
	
	@Test
	public void testAnnounceResults_WinnerOverSameRank() {

		TestDeck deck = new TestDeck();

		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(PlayerHandTest.getCard("Hearts", "3"));
		cards.add(PlayerHandTest.getCard("Clubs", "10"));
		cards.add(PlayerHandTest.getCard("Hearts", "Jack"));
		cards.add(PlayerHandTest.getCard("Clubs", "Queen"));

		deck.setCards(cards);

		Dealer dealer = new Dealer(deck, 2) {
			protected void shuffle(Deck deck) {
				// do nothing
			}
		};

		printPalyerHands(dealer);

		String result = dealer.announceResults();
		out.println(result);
		assertEquals("Winning hand : Hand-2(Rank 2)", result);
	}
	
	@Test
	public void testAnnounceResults_WinnerRank() {

		TestDeck deck = new TestDeck();

		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(PlayerHandTest.getCard("Hearts", "3"));
		cards.add(PlayerHandTest.getCard("Clubs", "10"));
		cards.add(PlayerHandTest.getCard("Hearts", "3"));
		cards.add(PlayerHandTest.getCard("Clubs", "Queen"));

		deck.setCards(cards);

		Dealer dealer = new Dealer(deck, 2) {
			protected void shuffle(Deck deck) {
				// do nothing
			}
		};

		printPalyerHands(dealer);

		String result = dealer.announceResults();
		out.println(result);
		assertEquals("Winning hand : Hand-1(Rank 1)", result);
	}



	private void printPalyerHands(Dealer dealer) {
		for (PlayerHand hand : dealer.getPlayerHands()) {
			System.out.println(hand + " has the following cards: ");
			for (Card card : hand.getCards()) {
				System.out.println(card);
			}
			out.println();
		}
	}

	private static class TestDeck extends Deck {
		TestDeck() {
		}
	}

}
