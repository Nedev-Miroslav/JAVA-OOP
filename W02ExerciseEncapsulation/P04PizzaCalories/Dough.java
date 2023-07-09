package W02ExerciseEncapsulation.P04PizzaCalories;

public class Dough {

    private String flourType;
    private String bakingTechnique;
    private double weight;



    public Dough(String flourType, String bakingTechnique, double weight) {
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
    }

    private void setFlourType(String flourType) {
        switch (flourType) {
            case "White":
            case "Wholegrain":
                this.flourType = flourType;
                break;
            default:
                throw new IllegalArgumentException("Invalid type of dough.");

        }


    }

    private void setBakingTechnique(String bakingTechnique) {
        switch (bakingTechnique) {
            case "Crispy":
            case "Chewy":
            case "Homemade":
                this.bakingTechnique = bakingTechnique;
                break;
            default:
                throw new IllegalArgumentException("Invalid type of dough.");

        }


    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }

        this.weight = weight;
    }


    public double calculateCalories() {
        double flour = 0;
        switch (flourType) {
            case "White":
                flour = 1.5;
                break;
            case "Wholegrain":
                flour = 1.0;
                break;
        }


        double technique = 0;

        switch (bakingTechnique) {

            case "Crispy":
                technique = 0.9;
                break;
            case "Chewy":
                technique = 1.1;
                break;
            case "Homemade":
                technique = 1.0;
                break;


        }

        return 2 * weight * flour * technique;


    }


}
