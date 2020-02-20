package test.java.com.yatzy.refactoring;

import main.java.com.yatzy.refactoring.Category;
import main.java.com.yatzy.refactoring.YatzyRoll;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class YatzyTest {

    @Test
    public void chance_scores_sum_of_all_dice() throws Exception {
        Assert.assertEquals(14, new YatzyRoll(1,1,3,3,6).placeOn(Category.CHANCE).getScore());
        assertEquals(21, new YatzyRoll(4,5,5,6,1).placeOn(Category.CHANCE).getScore());
    }

    @Test public void yatzy_scores_50() throws Exception {
        assertEquals(50, new YatzyRoll(1,1,1,1,1).placeOn(Category.YATZY).getScore());
        assertEquals(0, new YatzyRoll(1,1,1,2,1).placeOn(Category.YATZY).getScore());
    }

    @Test public void ones() throws Exception {
        assertEquals(2, new YatzyRoll(1,1,2,4,4).placeOn(Category.ONES).getScore());
        assertEquals(1, new YatzyRoll(2,3,2,5,1).placeOn(Category.ONES).getScore());
        assertEquals(0, new YatzyRoll(3,3,3,4,5).placeOn(Category.ONES).getScore());
    }

    @Test
    public void twos() throws Exception {
        assertEquals(4, new YatzyRoll(1,2,3,2,6).placeOn(Category.TWOS).getScore());
        assertEquals(0, new YatzyRoll(4,5,1,3,3).placeOn(Category.TWOS).getScore());
        assertEquals(10, new YatzyRoll(2,2,2,2,2).placeOn(Category.TWOS).getScore());
    }

    @Test
    public void test_threes() throws Exception {
        assertEquals(6, new YatzyRoll(1,2,3,2,3).placeOn(Category.THREES).getScore());
        assertEquals(0, new YatzyRoll(1,2,5,2,4).placeOn(Category.THREES).getScore());
        assertEquals(12, new YatzyRoll(2,3,3,3,3).placeOn(Category.THREES).getScore());
    }

    @Test
    public void fours() throws Exception {
        assertEquals(0, new YatzyRoll(1,1,6,2,6).placeOn(Category.FOURS).getScore());
        assertEquals(8, new YatzyRoll(1,1,2,4,4).placeOn(Category.FOURS).getScore());
        assertEquals(4,  new YatzyRoll(4,5,5,5,5).placeOn(Category.FOURS).getScore());
    }

    @Test
    public void fives() throws Exception {
        assertEquals(0, new YatzyRoll(4,4,4,3,2).placeOn(Category.FIVES).getScore());
        assertEquals(5, new YatzyRoll(4,4,5,1,3).placeOn(Category.FIVES).getScore());
        assertEquals(20, new YatzyRoll(4,5,5,5,5).placeOn(Category.FIVES).getScore());
    }

    @Test
    public void sixes() throws Exception {
        assertEquals(0, new YatzyRoll(4,4,4,5,5).placeOn(Category.SIXES).getScore());
        assertEquals(6, new YatzyRoll(4,4,6,5,5).placeOn(Category.SIXES).getScore());
        assertEquals(18, new YatzyRoll(6,5,6,6,5).placeOn(Category.SIXES).getScore());
    }

    @Test
    public void one_pair() throws Exception {
        assertEquals(8, new YatzyRoll(3,3,3,4,4).placeOn(Category.PAIR).getScore());
        assertEquals(12, new YatzyRoll(1,1,6,2,6).placeOn(Category.PAIR).getScore());
        assertEquals(6, new YatzyRoll(3,3,3,4,1).placeOn(Category.PAIR).getScore());
        assertEquals(0, new YatzyRoll(3,2,5,4,1).placeOn(Category.PAIR).getScore());
        assertEquals(6, new YatzyRoll(3,3,3,3,1).placeOn(Category.PAIR).getScore());
    }

    @Test
    public void two_Pair() throws Exception {
        assertEquals(8, new YatzyRoll(1,1,2,3,3).placeOn(Category.TWO_PAIRS).getScore());
        assertEquals(0, new YatzyRoll(1,1,2,3,4).placeOn(Category.TWO_PAIRS).getScore());
        assertEquals(6, new YatzyRoll(1,1,2,2,2).placeOn(Category.TWO_PAIRS).getScore());
    }

    @Test
    public void three_of_a_kind() throws Exception 
    {
        assertEquals(9, new YatzyRoll(3,3,3,4,5).placeOn(Category.THREE_OF_A_KIND).getScore());
        assertEquals(0, new YatzyRoll(3,3,4,5,6).placeOn(Category.THREE_OF_A_KIND).getScore());
        assertEquals(9, new YatzyRoll(3,3,3,3,1).placeOn(Category.THREE_OF_A_KIND).getScore());
    }

    @Test
    public void four_of_a_knd() throws Exception {
        assertEquals(8, new YatzyRoll(2,2,2,2,5).placeOn(Category.FOUR_OF_A_KIND).getScore());
        assertEquals(0, new YatzyRoll(2,2,2,5,5).placeOn(Category.FOUR_OF_A_KIND).getScore());
        assertEquals(12, new YatzyRoll(3,3,3,3,3).placeOn(Category.FOUR_OF_A_KIND).getScore());
    }

    @Test
    public void smallStraight() throws Exception {
        assertEquals(15, new YatzyRoll(1,2,3,4,5).placeOn(Category.SMALL_STRAIGHT).getScore());
        assertEquals(0, new YatzyRoll(2,3,4,5,1).placeOn(Category.SMALL_STRAIGHT).getScore());
        assertEquals(0, new YatzyRoll(1,2,2,4,5).placeOn(Category.SMALL_STRAIGHT).getScore());
    }

    @Test
    public void largeStraight() throws Exception {
    	assertEquals(20, new YatzyRoll(2,3,4,5,6).placeOn(Category.LARGE_STRAIGHT).getScore());
    	assertEquals(0, new YatzyRoll(6,2,3,4,5).placeOn(Category.LARGE_STRAIGHT).getScore());
        assertEquals(0, new YatzyRoll(1,2,2,4,5).placeOn(Category.LARGE_STRAIGHT).getScore());
    }

    @Test
    public void fullHouse() throws Exception {
        assertEquals(8, new YatzyRoll(1,1,2,2,2).placeOn(Category.FULL_HOUSE).getScore());
        assertEquals(0, new YatzyRoll(2,2,3,3,4).placeOn(Category.FULL_HOUSE).getScore());
        assertEquals(0, new YatzyRoll(4,4,4,4,4).placeOn(Category.FULL_HOUSE).getScore());
    }
}