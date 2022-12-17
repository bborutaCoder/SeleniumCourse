package tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TddCalculatorTests {

    @Test
    public void addTwoPlusTwoEqualsFour() {
        TddCalculator tddCalculator = new TddCalculator();

        Assertions.assertEquals(4, tddCalculator.add(2, 2));
    }

    @Test
    public void twoSubtractTwoEqualsZero() {
        TddCalculator tddCalculator = new TddCalculator();

        Assertions.assertEquals(0, tddCalculator.subtract(2, 2));
    }

    @Test
    public void twoMultiplyByTwoEqualsFour() {
        TddCalculator tddCalculator = new TddCalculator();

        Assertions.assertEquals(4, tddCalculator.multiply(2, 2));
    }

    @Test
    public void twoDividedByTwoEqualsOne() {
        TddCalculator tddCalculator = new TddCalculator();

        Assertions.assertEquals(1, tddCalculator.divide(2, 2));
    }

    // powinien byc tu tez test do sprawdzania, czy nie dzieli przez zero
}
