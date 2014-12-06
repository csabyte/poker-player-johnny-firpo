package org.leanpoker.gson;


public class Card {

    private String rank;

    private String suit;

    public Card(String rank, String suit) {
        super();
        this.rank = rank;
        this.suit = suit;
    }

    public int getRankValue() {
        if (rank.equals("A")) {
            return 14;
        }
        if (rank.equals("K")) {
            return 13;
        }
        if (rank.equals("Q")) {
            return 12;
        }
        if (rank.equals("J")) {
            return 11;
        }

        try {
            return Integer.parseInt(rank);
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
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
