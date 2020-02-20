package main.java.com.yatzy.refactoring;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class YatzyRoll {

    private Dice dice;
    private Category category;

    public YatzyRoll(int... dice) {
        this.dice = new Dice(dice);
    }

    public YatzyRoll placeOn(Category category) {
        this.category = category;
        return this;
    }

    public int getScore() throws Exception {
        if (this.category == null)
            throw new Exception("No category selected");
        int score = 0;
        switch (this.category) {
            case CHANCE:
                score = this.dice.sumDiceValue();
                break;
            case YATZY:
                score = this.dice.isYatzy() ? 50 : 0;
                break;
            case ONES:
                score = this.dice.numberOf(1);
                break;
            case TWOS:
                score = this.dice.numberOf(2) * 2;
                break;
            case THREES:
                score = this.dice.numberOf(3) * 3;
                break;
            case FOURS:
                score = this.dice.numberOf(4) * 4;
                break;
            case FIVES:
                score = this.dice.numberOf(5) * 5;
                break;
            case SIXES:
                score = this.dice.numberOf(6) * 6;
                break;
            case PAIR:
                List<Integer> pairs = this.dice.getPairs();
                if (pairs.size() >= 1) {
                    pairs.sort(Collections.reverseOrder());
                }
                score = pairs.size() >= 1 ? pairs.get(0) * 2 : 0;
                break;
            case TWO_PAIRS:
                List<Integer> twoPairs = this.dice.getPairs();
                score = twoPairs.size() == 2 ? twoPairs.stream().mapToInt(Integer::intValue).sum() * 2 : 0;
                break;
            case THREE_OF_A_KIND:
                Optional<Integer> threeOfAKind = this.dice.getThreeOfAKind();
                score = threeOfAKind.map(threeOfAKindValue -> threeOfAKindValue * 3).orElse(0);
                break;
            case FOUR_OF_A_KIND:
                Optional<Integer> fourOfAKind = this.dice.getFourOfAKind();
                score = fourOfAKind.map(fourOfAKindValue -> fourOfAKindValue * 4).orElse(0);
                break;
            case SMALL_STRAIGHT:
                score = this.dice.isSmallStraight() ? 15 : 0;
                break;
            case LARGE_STRAIGHT:
                score = this.dice.isLargeStraight() ? 20 : 0;
                break;
            case FULL_HOUSE:
                score = this.dice.isFullHouse() ? this.dice.sumDiceValue() : 0;
                break;
            default:
                break;
        }
        return score;
    }

}


