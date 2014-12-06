package org.leanpoker.player.gson;

public class Card {

    private String rank;

    private String suit;

    public Card(String rank, String suit) {
        super();
        this.rank = rank;
        this.suit = suit;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

}
