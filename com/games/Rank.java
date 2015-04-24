package com.games;

public enum Rank {
   //The rank defintion
   RANK_1(1, "Rank 1"){
	   @Override
       boolean matches(Card[] cards) {
               return (cards[1].getRank() == cards[0].getRank());
       }
   },
   RANK_2(2, "Rank 2"){
	   @Override
       boolean matches(Card[] cards) {
		   return (cards[1].getSuit() == cards[0].getSuit());
       }
   },
   RANK_3(3, "Rank 3") {
	   @Override
       boolean matches(Card[] cards) {
           return (cards[1].getSuit() != cards[0].getSuit()) && (cards[1].getRank() != cards[0].getRank());
       }
   };
   Integer value;
   String description;
   Rank(int value, String description) {
	   this.value = value; 
	   this.description = description;  
   }
   
   abstract boolean matches(Card[] cards);
}
