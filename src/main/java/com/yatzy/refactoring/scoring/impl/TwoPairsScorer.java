package main.java.com.yatzy.refactoring.scoring.impl;

import main.java.com.yatzy.refactoring.model.Dice;
import main.java.com.yatzy.refactoring.scoring.CategoryScorer;

import java.util.List;

public class TwoPairsScorer implements CategoryScorer {
    @Override
    public int scores(Dice dice) {
        List<Integer> twoPairs = dice.getPairs();
        return twoPairs.size() == 2 ? twoPairs.stream().mapToInt(Integer::intValue).sum() * 2 : 0;

    }
}
