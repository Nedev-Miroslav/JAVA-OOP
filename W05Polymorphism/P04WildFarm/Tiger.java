package W05Polymorphism.P04WildFarm;

import java.text.DecimalFormat;

public class Tiger extends Felime{
    private String livingRegion;

    public Tiger(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
        this.setLivingRegion(livingRegion);
    }

    @Override
    public String getLivingRegion() {
        return livingRegion;
    }

    @Override
    public void setLivingRegion(String livingRegion) {
        this.livingRegion = livingRegion;
    }

    @Override
    public void makeSound(){
        System.out.println("ROAAR!!!");
    }

    @Override
    public void eat(Food food) {
        if (food.getClass().getSimpleName().equals("Vegetable")) {
            this.setFoodEaten(0);
            System.out.println("Tigers are not eating that type of food!");
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
