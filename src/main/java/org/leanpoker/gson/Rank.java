package org.leanpoker.gson;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Rank {

    private List<Card> cards;

    @SerializedName("cards_used")
    private List<Card> cardsUsed;

    private int rank;

    private int value;

    private int secondValue;

    private int[] kickers;

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public List<Card> getCardsUsed() {
        return cardsUsed;
    }

    public void setCardsUsed(List<Card> cardsUsed) {
        this.cardsUsed = cardsUsed;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getSecondValue() {
        return secondValue;
    }

    public void setSecondValue(int secondValue) {
        this.secondValue = secondValue;
    }

    public int[] getKickers() {
        return kickers;
    }

    public void setKickers(int[] kickers) {
        this.kickers = kickers;
    }

}
