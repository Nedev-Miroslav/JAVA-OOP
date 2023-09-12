package fairyShop.models.helper;

public class Sleepy extends BaseHelper {

    public Sleepy(String name) {
        super(name, 50);
    }

    @Override
    public void work() {
        if (this.getEnergy() - 5 > 0) {
            this.setEnergy(this.getEnergy() - 5);
        } else {
            this.setEnergy(0);
        }
    }
}
