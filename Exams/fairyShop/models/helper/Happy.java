package fairyShop.models.helper;

public class Happy extends BaseHelper{


    public Happy(String name) {
        super(name, 100);
    }
    @Override
    public void work() {
        if(this.getEnergy() - 10 > 0){
            this.setEnergy(this.getEnergy() - 10);
        } else {
            this.setEnergy(0);
        }

    }
}
