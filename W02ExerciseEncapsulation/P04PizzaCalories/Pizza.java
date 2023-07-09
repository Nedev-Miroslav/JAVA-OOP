package W02ExerciseEncapsulation.P04PizzaCalories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {


    private String name;
    private Dough dough;
    private List<Topping>toppings;

    public Pizza(String name, int numberOfToppings) {
        this.name = name;

        this.setToppings(numberOfToppings);
    }

    private void setName(String name) {
        if(name.trim().length() < 1 || name.trim().length() > 15) {
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }

        this.name = name;
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    private void setToppings(int numberOfToppings) {
        if (numberOfToppings < 0 || numberOfToppings > 10) {
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
        this.toppings = new ArrayList<>();

    }
    public void addTopping(Topping topping){
        toppings.add(topping);
    }

    public String getName() {
        return name;
    }

    public double getOverallCalories (){
        return dough.calculateCalories() + toppings.stream().mapToDouble(Topping::calculateCalories).sum();
    }


}
