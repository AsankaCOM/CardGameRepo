package com.games;

import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class PlayerHandTest {

	@Test
	public void testCompareTo_diferentRanks() {
		PlayerHand[] hands = new PlayerHand[] {
				getPlayerHand(getCard("Diamonds", "3"), getCard("Diamonds", "4"), 1), //Rank 2
				getPlayerHand(getCard("Clubs", "Jack"),getCard("Hearts", "King"), 2), //Rank 3
				getPlayerHand(getCard("Clubs", "1"),getCard("Hearts", "1"), 3)};      //Rank 1

		Arrays.sort(hands);

		PlayerHand[] expected = new PlayerHand[] {
				getPlayerHand(getCard("Clubs", "1"),getCard("Hearts", "1"), 3),
				getPlayerHand(getCard("Diamonds", "3"), getCard("Diamonds", "4"), 1),
				getPlayerHand(getCard("Clubs", "Jack"),getCard("Hearts", "King"), 2)};

		assertArrayEquals(expected, hands);
		assertEquals(Rank.RANK_1, hands[0].evaluateHand());
	}
	
	@Test
	public void testCompareTo_sameRank() {
		PlayerHand[] hands = new PlayerHand[] {
				getPlayerHand(getCard("Diamonds", "3"), getCard("Spades", "4"), 1),
				getPlayerHand(getCard("Clubs", "2"),getCard("Hearts", "Queen"), 2) }; 

		Arrays.sort(hands);

		PlayerHand[] expected = new PlayerHand[] {
				getPlayerHand(getCard("Hearts", "Queen"),getCard("Clubs", "2"), 2),
				getPlayerHand(getCard("Spades", "4"), getCard("Diamonds", "3"), 1) };

		assertArrayEquals(expected, hands);
	}

	public static  PlayerHand getPlayerHand(Card card1, Card card2, int order) {
		PlayerHand playerHand = new PlayerHand(2, order);
		Card[] cards = playerHand.getCards();
		cards[0] = card1;
		cards[1] = card2;
		return playerHand;
	}

	public static Card getCard(String suite, String rank) {
		List<String> ranks = Arrays.asList(Card.ranks);
		List<String> suits = Arrays.asList(Card.suits);

		Card card = new Card((short) suits.indexOf(suite),
				(short) ranks.indexOf(rank));
		// out.println(card);
		return card;
	}
}
