package W04InterfacesAndAbstraction.P02CarShopExtend;

public class Seat extends CarImpl implements Sellable {
    private Double price;

    public Seat(String model, String color, Integer hp, String country, Double price) {
        super(model, color, hp, country);
        this.price = price;
    }

    @Override
    public Double getPrice() {
        return price;
    }
    @Override
    public String toString() {
        return String.format("%s%n%s sells for %f", super.toString(), getModel(), price);
    }


}
