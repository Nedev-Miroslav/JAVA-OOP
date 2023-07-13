package W04InterfacesAndAbstraction.P01CarShop;

public class Seat implements Car{

    public String model;
    public String color;
    public Integer hp;
    public String country;

    public Seat(String model, String color, Integer hp, String country) {
        this.model = model;
        this.color = color;
        this.hp = hp;
        this.country = country;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public Integer getHorsePower() {
        return hp;
    }

    @Override
    public String countryProduced() {
        return country;
    }

    @Override
    public String toString() {
        return String.format("This is %s produced in %s and have %d tires", this.model, this.country, Car.TIRES);
    }
}
