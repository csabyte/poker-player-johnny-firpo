package org.leanpoker.ranking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import org.leanpoker.gson.Card;
import org.leanpoker.gson.Rank;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class RankingClient {

    public static Rank getRank(final List<Card> cards) {
        try {

            Gson gson = new Gson();

            URL url;
            url = new URL("http://localhost:2048/");

            URLConnection openConnection = url.openConnection();
            HttpURLConnection connection = (HttpURLConnection) openConnection;
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setInstanceFollowRedirects(false);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setRequestProperty("charset", "utf-8");
            connection.connect();

            PrintWriter wr = new PrintWriter(connection.getOutputStream());
            wr.write("cards=" + gson.toJson(cards));
            wr.flush();
            wr.close();

            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                response.append(line);
            }
            br.close();

            return gson.fromJson(response.toString(), Rank.class);
        } catch (IOException e) {
            System.out.println(e);
        }

        return null;
    }

    public static void main(String[] args) throws IOException {
        List<Card> cards = new ArrayList<>();

        // magas lap
        // cards.add(new Card("2", "clubs"));
        // cards.add(new Card("3", "diamonds"));
        // cards.add(new Card("4", "clubs"));
        // cards.add(new Card("K", "diamonds"));
        // cards.add(new Card("6", "clubs"));

        // 2 pár
        cards.add(new Card("2", "clubs"));
        cards.add(new Card("2", "diamonds"));
        cards.add(new Card("4", "clubs"));
        cards.add(new Card("6", "diamonds"));
        cards.add(new Card("6", "clubs"));

        // straight flush
        // cards.add(new Card("2", "clubs"));
        // cards.add(new Card("3", "clubs"));
        // cards.add(new Card("4", "clubs"));
        // cards.add(new Card("5", "clubs"));
        // cards.add(new Card("6", "clubs"));

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        System.out.println(gson.toJson(getRank(cards)));
    }

}
