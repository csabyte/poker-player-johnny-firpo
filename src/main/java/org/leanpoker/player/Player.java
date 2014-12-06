package org.leanpoker.player;

import org.leanpoker.player.gson.GameState;
import com.google.gson.Gson;
import com.google.gson.JsonElement;

public class Player {

    static final String VERSION = "Default Java folding player";

    public static int betRequest(JsonElement request) {
        Gson gson = new Gson();
        gson.fromJson(request, GameState.class);

        return allIn();
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
