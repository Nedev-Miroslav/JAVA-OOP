package catHouse.entities.cat;

public class ShorthairCat extends BaseCat{
    private final static int KG = 7;

    public ShorthairCat(String name, String breed, double price) {
        super(name, breed, KG , price);
    }


    @Override
    public void eating() {
        this.setKilograms(this.getKilograms() + 1);
    }
}
