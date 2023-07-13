package W04InterfacesAndAbstraction.P02CarShopExtend;

public class CarImpl implements Car{
    private String model;
    private String color;
    private Integer hp;
    private String country;


    public CarImpl(String model, String color, Integer hp, String country) {
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
       StringBuilder sb = new StringBuilder();

        return String.format("This is %s produced in %s and have %d tires", this.model, this.country, Car.TIRES);
    }
}
