package org.leanpoker.player;

import org.leanpoker.player.gson.GameState;
import com.google.gson.Gson;
import com.google.gson.JsonElement;

public class Player {

    static final String VERSION = "Default Java folding player";

    public static int betRequest(JsonElement request) {
        Gson gson = new Gson();
        gson.fromJson(request, GameState.class);

        return 100;
        // return allIn();
    }

    public static int allIn() {
        return 1000;
    }

    public static void showdown(JsonElement game) {
    }
}
