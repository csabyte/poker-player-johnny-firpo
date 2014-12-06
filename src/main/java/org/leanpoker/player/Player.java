package org.leanpoker.player;

import java.util.List;
import org.leanpoker.player.gson.Card;
import org.leanpoker.player.gson.GameState;
import com.google.gson.Gson;
import com.google.gson.JsonElement;

public class Player {

    static final String VERSION = "Default Java folding player";

    public static int betRequest(JsonElement request) {
        Gson gson = new Gson();
        GameState state = gson.fromJson(request, GameState.class);

        List<Card> hand = state.getPlayers().get(state.getInAction()).getHoleCards();

        // Párunk van.
        if (hand.get(0).getRankValue() == hand.get(1).getRankValue()) {
            return allIn();
        }

        // Azonos színű lapunk van.
        if (hand.get(0).getSuit().equals(hand.get(1).getSuit())) {
            return checkOrFold();
        }

        return checkOrFold();
    }

    private static int checkOrFold() {
        return 0;
    }

    private static int call(GameState state) {
        return state.getCurrentBuyIn() - state.getPlayers().get(state.getInAction()).getBet();
    }

    private static int raise(GameState state) {
        return state.getCurrentBuyIn() - state.getPlayers().get(state.getInAction()).getBet() + state.getMinimumRaise();
    }

    private static int allIn() {
        return 10000;
    }

    public static void showdown(JsonElement game) {
    }
}
