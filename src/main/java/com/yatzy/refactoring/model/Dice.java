package main.java.com.yatzy.refactoring.model;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Dice {

    private static final int MIN_DIE_FACE = 1;
    private static final int MAX_DIE_FACE = 6;

    private List<Integer> listDiceValue;
    private final int[] dieOccurrences;


    public Dice(int... diceValue) {
        this.listDiceValue = Arrays.stream(diceValue).boxed().collect(Collectors.toList());
        this.dieOccurrences = new int[MAX_DIE_FACE];
        this.listDiceValue.forEach(this::incrementDieOccurrence);
    }

    private void incrementDieOccurrence(Integer die) {
        this.dieOccurrences[die - 1]++;
    }


    public int sumDiceValue() {
        return this.listDiceValue.stream().mapToInt(Integer::intValue).sum();
    }

    public int numberOf(int value) {
        return (int) listDiceValue.stream().filter(i -> i == value).count();
    }

    public Optional<Integer> getThreeOfAKind() {
        return IntStream.rangeClosed(MIN_DIE_FACE, MAX_DIE_FACE)
                .filter(this::isThreeOfAKind)
                .boxed().findAny();
    }

    public Optional<Integer> getFourOfAKind() {
        return IntStream.rangeClosed(MIN_DIE_FACE, MAX_DIE_FACE)
                .filter(this::isFourOfAKind)
                .boxed().findAny();
    }

    private boolean isThreeOfAKind(int dieValue) {
        return dieOccurrences[dieValue - 1] >= 3;
    }

    private boolean isFourOfAKind(int dieValue) {
        return dieOccurrences[dieValue - 1] >= 4;
    }

    public boolean isSmallStraight() {
        List<Integer> straightDice = IntStream.rangeClosed(MIN_DIE_FACE, MAX_DIE_FACE - 1)
                .boxed().collect(Collectors.toList());
        return straightDice.equals(listDiceValue);
    }

    public boolean isLargeStraight() {
        List<Integer> straightDice = IntStream.rangeClosed(MIN_DIE_FACE + 1, MAX_DIE_FACE)
                .boxed().collect(Collectors.toList());
        return straightDice.equals(listDiceValue);
    }

    private boolean isPair(int dieValue) {
        return dieOccurrences[dieValue - 1] >= 2;
    }

    public List<Integer> getPairs() {
        return IntStream.rangeClosed(MIN_DIE_FACE, MAX_DIE_FACE)
                .filter(this::isPair)
                .boxed().collect(Collectors.toList());
    }

    public boolean isFullHouse() {
        boolean hasThreeOfAKind = false;
        boolean hasPair = false;
        for (int value = MIN_DIE_FACE; value <= MAX_DIE_FACE; value++) {
            if (isThreeOfAKind(value)) {
                hasThreeOfAKind = true;
            } else if (isPair(value)) {
                hasPair = true;
            }
        }
        return hasThreeOfAKind && hasPair;
    }

    public boolean isYatzy() {
        return Arrays.stream(dieOccurrences).anyMatch(dieOccurence -> dieOccurence == 5);
    }

}
