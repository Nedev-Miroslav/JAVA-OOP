package W05Polymorphism.P04WildFarm;

import java.text.DecimalFormat;

public class Cat extends Felime{
    private String breed;
    public Cat(String animalName, String animalType, Double animalWeight, String livingRegion, String breed) {
        super(animalName, animalType, animalWeight, livingRegion);
        this.setBreed(breed);
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void makeSound(){
        System.out.println("Meowwww");
    }

    @Override
    public void eat(Food food) {
     this.setFoodEaten(food.getQuantity());


    }
    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.##");
        return String.format("%s[%s, %s, %s, %s, %d]",this.getAnimalType(), this.getAnimalName(), this.getBreed(), df.format(this.getAnimalWeight()), this.getLivingRegion(), getFoodEaten());
    }

}
