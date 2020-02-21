package main.java.com.yatzy.refactoring.model;

import main.java.com.yatzy.refactoring.scoring.*;
import main.java.com.yatzy.refactoring.scoring.impl.*;

public enum Category implements CategoryScorer {
    CHANCE(new ChanceScorer()),
    YATZY(new YatzyScorer()),
    ONES(new OnesScorer()),
    TWOS(new TwosScorer()),
    THREES(new ThreesScorer()),
    FOURS(new FoursScorer()),
    FIVES(new FivesScorer()),
    SIXES(new SixesScorer()),
    PAIR(new PairScorer()),
    TWO_PAIRS(new TwoPairsScorer()),
    THREE_OF_A_KIND(new ThreeOfAKindScorer()),
    FOUR_OF_A_KIND(new FourOfAKindScorer()),
    SMALL_STRAIGHT(new SmallStraightScorer()),
    LARGE_STRAIGHT(new LargeStraightScorer()),
    FULL_HOUSE(new FullHouseScorer());

    private CategoryScorer scorer;

    Category(CategoryScorer scorer) {
        this.scorer = scorer;
    }

    @Override
    public int scores(Dice dice) {
        return scorer.scores(dice);
    }

}
