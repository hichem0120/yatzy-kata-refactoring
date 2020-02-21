package main.java.com.yatzy.refactoring.scoring.impl;

import main.java.com.yatzy.refactoring.model.Dice;
import main.java.com.yatzy.refactoring.scoring.CategoryScorer;

import java.util.Optional;

public class FourOfAKindScorer implements CategoryScorer {
    @Override
    public int scores(Dice dice) {
        Optional<Integer> fourOfAKind = dice.getFourOfAKind();
        return fourOfAKind.map(fourOfAKindValue -> fourOfAKindValue * 4).orElse(0);
    }
}
