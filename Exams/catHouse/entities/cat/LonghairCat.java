package catHouse.entities.cat;

public class LonghairCat extends BaseCat {
    private final static int KG = 9;

    public LonghairCat(String name, String breed, double price) {
        super(name, breed, KG, price);
    }



    @Override
    public void eating() {
        this.setKilograms(this.getKilograms() + 3);
    }
}
