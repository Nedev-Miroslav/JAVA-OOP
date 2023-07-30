package W08SOLID.products.food;

public abstract class BaseFood implements Food {
    private double caloriePer100Gr;
    private double grams;

    public BaseFood(double caloriePer100Gr, double grams) {
        this.caloriePer100Gr = caloriePer100Gr;
        this.grams = grams;
    }

    public double getCaloriePer100Gr() {
        return caloriePer100Gr;
    }

    public double getGrams() {
        return grams;
    }

    @Override
    public double findCalories() {
        return (caloriePer100Gr / 100) * grams;
    }
    @Override
    public double getKilograms(){
        return this.grams / 1000;
    }

}
