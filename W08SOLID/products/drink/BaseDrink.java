package W08SOLID.products.drink;

public abstract class BaseDrink implements Drink {
    private double milliliters;
    private double density;
    private double caloriePer100gr;

    public double getMilliliters() {
        return milliliters;
    }

    public double getDensity() {
        return density;
    }

    public double getCaloriePer100gr() {
        return caloriePer100gr;
    }

    public BaseDrink(double milliliters, double density, double caloriePer100gr) {
        this.milliliters = milliliters;
        this.density = density;
        this.caloriePer100gr = caloriePer100gr;
    }



    @Override
    public double findCalories() {
       return  ((caloriePer100gr / 100) * milliliters * density);
    }
    @Override
    public double getLiters(){
        return this.milliliters / 1000;
    }

}
