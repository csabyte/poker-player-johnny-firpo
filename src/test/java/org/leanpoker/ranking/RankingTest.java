package org.leanpoker.ranking;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.Test;
import org.leanpoker.gson.Card;

public class RankingTest {

    @Test
    public void lowPair() {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card("2", "diamonds"));
        hand.add(new Card("2", "clubs"));

        Ranking ranking = new Ranking(hand, Collections.EMPTY_LIST);

        assertEquals(1, ranking.getRank());
        assertEquals(2, ranking.getFirstValue());
        assertEquals(2, ranking.getUsedFromHoleCards());
    }

    @Test
    public void highPair() {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card("A", "diamonds"));
        hand.add(new Card("A", "clubs"));

        Ranking ranking = new Ranking(hand, Collections.EMPTY_LIST);

        assertEquals(1, ranking.getRank());
        assertEquals(14, ranking.getFirstValue());
        assertEquals(2, ranking.getUsedFromHoleCards());
    }

    @Test
    public void highPairAfterFlopOneFromHand() {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card("A", "diamonds"));
        hand.add(new Card("2", "clubs"));

        List<Card> community = new ArrayList<>();
        community.add(new Card("6", "hearts"));
        community.add(new Card("A", "clubs"));
        community.add(new Card("9", "clubs"));

        Ranking ranking = new Ranking(hand, community);

        assertEquals(1, ranking.getRank());
        assertEquals(14, ranking.getFirstValue());
        assertEquals(1, ranking.getUsedFromHoleCards());
    }

    @Test
    public void highPairAfterFlopTwoFromHand() {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card("4", "diamonds"));
        hand.add(new Card("2", "clubs"));

        List<Card> community = new ArrayList<>();
        community.add(new Card("A", "hearts"));
        community.add(new Card("A", "clubs"));
        community.add(new Card("9", "clubs"));

        Ranking ranking = new Ranking(hand, community);

        assertEquals(1, ranking.getRank());
        assertEquals(14, ranking.getFirstValue());
        assertEquals(0, ranking.getUsedFromHoleCards());
    }

}
