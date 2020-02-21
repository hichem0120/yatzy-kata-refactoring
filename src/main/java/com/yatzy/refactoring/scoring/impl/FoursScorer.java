package main.java.com.yatzy.refactoring.scoring.impl;

import main.java.com.yatzy.refactoring.model.Dice;
import main.java.com.yatzy.refactoring.scoring.CategoryScorer;

public class FoursScorer implements CategoryScorer {
    @Override
    public int scores(Dice dice) {
        return dice.numberOf(4) * 4;
    }
}
