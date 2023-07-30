package W08SOLID.Calculators;

import W08SOLID.products.Product;

import java.util.List;

public class CalorieCalculator implements Calculator {

    @Override
    public double sum(List<Product> products) {
        double sum = 0;

        for (Product product : products) {
            sum += product.findCalories();
        }

        return sum;
    }
    @Override
    public double average(List<Product> products) {
        return sum(products) / products.size();
    }


}
