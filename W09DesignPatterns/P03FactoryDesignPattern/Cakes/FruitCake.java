package W09DesignPatterns.P03FactoryDesignPattern.Cakes;

import W09DesignPatterns.P03FactoryDesignPattern.Cake;

public class FruitCake extends Cake {
    public FruitCake(double diameter, double price, int pieces) {
        super(diameter, price, pieces);
    }

    @Override
    public void prepare() {

    }

    @Override
    public void bake() {

    }

    @Override
    public void box() {

    }
}
