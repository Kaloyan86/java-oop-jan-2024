package solid_principles.solid;

import java.util.List;

public class Printer {

    private static final String SUM = "Sum: %f";
    private static final String AVERAGE = "Average: %f";

    Calculator calculator;

    public Printer(Calculator calculator) {
        this.calculator = calculator;
    }

    public void printSum(List<Food> products) {
        System.out.printf((SUM) + "%n", calculator.sum(products));
    }

    public void printAverage(List<Food> products) {
        System.out.printf((AVERAGE) + "%n", calculator.average(products));
    }
}
