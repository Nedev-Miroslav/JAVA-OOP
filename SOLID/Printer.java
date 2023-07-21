package SOLID;

import SOLID.Calculators.Calculator;
import SOLID.Calculators.CalorieCalculator;
import SOLID.products.Product;

import java.util.List;

public class Printer {
    private static final String SUM = "Sum: %f";
    private static final String AVERAGE = "Average: %f";
    private Calculator calculator;

    public Printer(CalorieCalculator calorieCalculator) {
        this.calculator = calorieCalculator;
    }

    public void printSum(List<Product> products) {
        System.out.printf((SUM) + "%n", calculator.sum(products));
    }

    public void printAverage(List<Product> products) {
        System.out.printf((AVERAGE) + "%n", calculator.average(products));
    }
}
