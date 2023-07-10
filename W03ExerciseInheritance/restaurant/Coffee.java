package W03ExerciseInheritance.restaurant;

import java.math.BigDecimal;

public class Coffee extends HotBeverage{


    private double caffeine;

    public static final double COFFEE_MILLILITERS = 50;
    public static final BigDecimal COFFEE_PRICE = BigDecimal.valueOf(3.50);
    public Coffee(String name, double caffeine) {
        super(name, COFFEE_PRICE, COFFEE_MILLILITERS);
        this.caffeine = caffeine;



    }

    public double getCaffeine() {
        return caffeine;
    }

    public void setCaffeine(double caffeine) {
        this.caffeine = caffeine;
    }
}
