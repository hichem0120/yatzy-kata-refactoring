package main.java.com.yatzy.refactoring.scoring.impl;

import main.java.com.yatzy.refactoring.model.Dice;
import main.java.com.yatzy.refactoring.scoring.CategoryScorer;

import java.util.Optional;

public class ThreeOfAKindScorer implements CategoryScorer {
    @Override
    public int scores(Dice dice) {
        Optional<Integer> threeOfAKind = dice.getThreeOfAKind();
        return threeOfAKind.map(threeOfAKindValue -> threeOfAKindValue * 3).orElse(0);

    }
}
