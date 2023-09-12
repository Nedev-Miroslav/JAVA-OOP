package zoo.entities.areas;

import zoo.common.ExceptionMessages;
import zoo.entities.animals.Animal;
import zoo.entities.foods.Food;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public abstract class BaseArea implements Area {

    private String name;
    private int capacity;
    private Collection<Food> foods;
    private Collection<Animal> animals;

    public BaseArea(String name, int capacity) {
        this.setName(name);
        this.capacity = capacity;
        this.foods = new ArrayList<>();
        this.animals = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.AREA_NAME_NULL_OR_EMPTY);
        }

        this.name = name;
    }

    @Override
    public Collection<Animal> getAnimals() {
        return animals;
    }

    @Override
    public Collection<Food> getFoods() {
        return foods;
    }

    @Override
    public int sumCalories() {
        return foods.stream().mapToInt(Food::getCalories).sum();
    }

    @Override
    public void addAnimal(Animal animal) {
        if (capacity <= this.getAnimals().size()) {
            throw new IllegalStateException(ExceptionMessages.NOT_ENOUGH_CAPACITY);
        }
        this.getAnimals().add(animal);

    }

    @Override
    public void removeAnimal(Animal animal) {
        this.getAnimals().remove(animal);
    }

    @Override
    public void addFood(Food food) {
        this.getFoods().add(food);

    }

    @Override
    public void feed() {

        animals.forEach(Animal::eat);

    }

    @Override
    public String getInfo() {
        StringBuilder sb = new StringBuilder();


        sb.append(String.format("%s (%s):", this.getName(), this.getClass().getSimpleName()));
        sb.append(System.lineSeparator());
        sb.append("Animals: ");
        if(getAnimals().isEmpty()){
            sb.append("none");
        } else {
            sb.append(this.getAnimals().stream().map(Animal::getName).collect(Collectors.joining(" ")).trim());
        }
        sb.append(System.lineSeparator());

        sb.append(String.format("Foods: %d", this.getFoods().size()));
        sb.append(System.lineSeparator());
        sb.append(String.format("Calories: %d", sumCalories()));
        sb.append(System.lineSeparator());

        return sb.toString().trim();
    }
}
