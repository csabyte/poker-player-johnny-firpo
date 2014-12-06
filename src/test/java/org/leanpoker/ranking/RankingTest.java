package org.leanpoker.ranking;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.leanpoker.gson.Card;

public class RankingTest {

    @Test
    public void lowPair() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card("2", "diamonds"));
        cards.add(new Card("2", "clubs"));

        Ranking ranking = new Ranking(cards);

        assertEquals(1, ranking.getRank());
        assertEquals(2, ranking.getFirstValue());
    }

    @Test
    public void highPair() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card("A", "diamonds"));
        cards.add(new Card("A", "clubs"));

        Ranking ranking = new Ranking(cards);

        assertEquals(1, ranking.getRank());
        assertEquals(14, ranking.getFirstValue());
    }

    @Test
    public void highPairInMoreCard() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card("A", "diamonds"));
        cards.add(new Card("2", "clubs"));
        cards.add(new Card("6", "hearts"));
        cards.add(new Card("A", "clubs"));
        cards.add(new Card("9", "clubs"));

        Ranking ranking = new Ranking(cards);

        assertEquals(1, ranking.getRank());
        assertEquals(14, ranking.getFirstValue());
    }

}
