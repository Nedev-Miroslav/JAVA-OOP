package W05Polymorphism.P04WildFarm;

import java.text.DecimalFormat;

public class Mouse extends Mammal {
    public Mouse(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }
    @Override
    public void makeSound(){
        System.out.println("SQUEEEAAAK!");
    }

    @Override
    public void eat(Food food) {
        if (food.getClass().getSimpleName().equals("Meat")) {
            this.setFoodEaten(0);
            System.out.println("Mice are not eating that type of food!");
        } else {
            this.setFoodEaten(food.getQuantity());
        }
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.##");
        return String.format("%s[%s, %s, %s, %d]",this.getAnimalType(), this.getAnimalName(), df.format(this.getAnimalWeight()), this.getLivingRegion(), getFoodEaten());
    }

}
