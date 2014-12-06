package org.leanpoker.ranking;

import java.util.List;
import org.leanpoker.gson.Card;

public class Ranking {

    private List<Card> cards;

    private int rank;

    private int firstValue;

    private List<Card> cardsUsed;

    public Ranking(List<Card> cards) {
        this.cards = cards;
        processRank();
    }

    public int getRank() {
        return rank;
    }

    public void processRank() {
        checkPair();
    }

    public int getFirstValue() {
        return firstValue;
    }

    private boolean checkPair() {
        int[] cardRank = new int[15];
        for (Card card : cards) {
            cardRank[card.getRankValue()]++;
        }

        for (int i = 14; i > 1; i--) {
            if (cardRank[i] == 2) {
                rank = 1;
                firstValue = i;
                return true;
            }
        }

        return false;
    }
}
