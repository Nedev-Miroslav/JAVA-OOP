package W08SOLID.Calculators;


import W08SOLID.products.Product;
import W08SOLID.products.drink.Drink;
import W08SOLID.products.food.Food;

import java.util.List;

public class QuantityCalculator implements Calculator{
    @Override
    public double sum (List<Product> products) {
        double sum = 0;
        for (Product product : products) {

            if (product instanceof Drink) {
                sum += ((Drink) product).getLiters() * ((Drink) product).getDensity();
            } else if (product instanceof Food) {
                sum += ((Food) product).getKilograms();
            }


        }
        return sum;
    }

        @Override
        public double average (List<Product> products) {

                return sum(products) / products.size();
        }

}
