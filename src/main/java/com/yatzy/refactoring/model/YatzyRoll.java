package main.java.com.yatzy.refactoring.model;

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
        if (this.category == null) {
            throw new Exception("No category selected");
        }
        return this.category.scores(dice);
    }

}


