package org.leanpoker.player;

import java.util.ArrayList;
import java.util.List;
import org.leanpoker.gson.Card;
import org.leanpoker.gson.GameState;
import org.leanpoker.ranking.Ranking;
import com.google.gson.Gson;
import com.google.gson.JsonElement;

public class Player {

    static final String VERSION = "Ranking pair v2.0";

    public static int betRequest(JsonElement request) {
        Gson gson = new Gson();
        GameState state = gson.fromJson(request, GameState.class);

        List<Card> hand = state.getPlayers().get(state.getInAction()).getHoleCards();
        List<Card> community = state.getCommunityCards();
        Ranking ranking = new Ranking(hand, community);

        // Hand Pair
        if (ranking.getRank() == 1) {
            // PreFlop
            if (isPreFlop(state)) {
                if (ranking.getRank() > 8) {
                    return allIn();
                } else {
                    checkOrFold();
                }
            }
            
            // AfterFlop
            if (ranking.getUsedFromHoleCards() == 2) {
                return allIn();
            }
            if (ranking.getUsedFromHoleCards() == 1) {
                return call(state);
            }
            if (ranking.getUsedFromHoleCards() == 0) {
                return checkOrFold();
            }
        }

        // Flush
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
    
    private static boolean isPreFlop(GameState state) {
        return state.getCommunityCards().size() == 0;
    }

    public static void showdown(JsonElement game) {
    }
}
