package W02ExerciseEncapsulation.P04PizzaCalories;

public class Topping {


    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        this.setToppingType(toppingType);
        this.setWeight(weight);

    }

    private void setToppingType(String toppingType) {
        switch (toppingType) {
            case "Meat":
            case "Veggies":
            case "Cheese":
            case "Sauce":
            this.toppingType = toppingType;
            break;
            default:
                throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.", toppingType));

        }
    }

    private void setWeight(double weight) {
        if(weight < 1 || weight > 50){
            throw new IllegalArgumentException(String.format("%s weight should be in the range [1..50].", this.toppingType));
        }

        this.weight = weight;
    }

    public double calculateCalories() {
        double ingredients = 0;
        switch (toppingType){
            case "Meat":
                ingredients = 1.2;
                break;
            case "Veggies":
                ingredients = 0.8;
                break;
            case "Cheese":
                ingredients = 1.1;
                break;
            case "Sauce":
                ingredients = 0.9;
                break;
        }

        return 2 * weight * ingredients;

    }


}
