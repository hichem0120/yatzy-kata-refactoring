package main.java.com.yatzy.refactoring.scoring.impl;

import main.java.com.yatzy.refactoring.model.Dice;
import main.java.com.yatzy.refactoring.scoring.CategoryScorer;

public class FullHouseScorer implements CategoryScorer {
    @Override
    public int scores(Dice dice) {
        return dice.isFullHouse() ? dice.sumDiceValue() : 0;
    }
}
