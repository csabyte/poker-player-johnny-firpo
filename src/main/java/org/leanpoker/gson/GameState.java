package org.leanpoker.gson;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class GameState {

    private List<Player> players;

    @SerializedName("small_blind")
    private int smallBlind;

    private int orbits;

    private int dealer;

    @SerializedName("community_cards")
    private List<Card> communityCards;

    @SerializedName("current_buy_in")
    private int currentBuyIn;

    private int pot;

    @SerializedName("in_action")
    private int inAction;

    @SerializedName("minimum_raise")
    private int minimumRaise;

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public int getSmallBlind() {
        return smallBlind;
    }

    public void setSmallBlind(int smallBlind) {
        this.smallBlind = smallBlind;
    }

    public int getOrbits() {
        return orbits;
    }

    public void setOrbits(int orbits) {
        this.orbits = orbits;
    }

    public int getDealer() {
        return dealer;
    }

    public void setDealer(int dealer) {
        this.dealer = dealer;
    }

    public List<Card> getCommunityCards() {
        return communityCards;
    }

    public void setCommunityCards(List<Card> communityCards) {
        this.communityCards = communityCards;
    }

    public int getCurrentBuyIn() {
        return currentBuyIn;
    }

    public void setCurrentBuyIn(int currentBuyIn) {
        this.currentBuyIn = currentBuyIn;
    }

    public int getPot() {
        return pot;
    }

    public void setPot(int pot) {
        this.pot = pot;
    }

    public int getInAction() {
        return inAction;
    }

    public void setInAction(int inAction) {
        this.inAction = inAction;
    }

    public int getMinimumRaise() {
        return minimumRaise;
    }

    public void setMinimumRaise(int minimumRaise) {
        this.minimumRaise = minimumRaise;
    }

}
