package org.leanpoker.ranking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.leanpoker.gson.Card;

public class Ranking {

    private List<Card> allCards;

    private int rank;

    private int firstValue;

    // private List<Card> cardsUsed;

    private List<Card> handCards;

    private List<Card> communityCards;

    private int usedFromHoleCards;

    private List<Card>[] cardRank = new List[15];

    public Ranking(List<Card> handCards, List<Card> communityCards) {
        allCards = new ArrayList<>();
        allCards.addAll(handCards);
        allCards.addAll(communityCards);

        this.handCards = new ArrayList<Card>();
        this.handCards.addAll(handCards);

        this.communityCards = new ArrayList<Card>();
        this.communityCards.addAll(communityCards);

        for (int i = 0; i < cardRank.length; i++) {
            cardRank[i] = new ArrayList<Card>();
        }

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

    public int getUsedFromHoleCards() {
        return usedFromHoleCards;
    }

    private boolean checkPair() {
        for (Card card : allCards) {
            cardRank[card.getRankValue()].add(card);
        }

        for (int i = 14; i > 1; i--) {
            if (cardRank[i].size() == 2) {
                rank = 1;
                firstValue = i;

                handCards.removeAll(cardRank[i]);
                usedFromHoleCards = 2 - handCards.size();
                return true;
            }
        }
        return false;
    }
}
