package tdd;

public class CalculatorNoTdd {

    public double add(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) {
        if (b == 0)
            throw new ArithmeticException("b is 0");

        return a / b;
    }
}
