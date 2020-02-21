package main.java.com.yatzy.refactoring.scoring.impl;

import main.java.com.yatzy.refactoring.model.Dice;
import main.java.com.yatzy.refactoring.scoring.CategoryScorer;

import java.util.Collections;
import java.util.List;

public class PairScorer implements CategoryScorer {
    @Override
    public int scores(Dice dice) {
        List<Integer> pairs = dice.getPairs();
        if (pairs.size() < 1) {
            return 0;
        }
        pairs.sort(Collections.reverseOrder());
        return pairs.get(0) * 2;
    }
}
