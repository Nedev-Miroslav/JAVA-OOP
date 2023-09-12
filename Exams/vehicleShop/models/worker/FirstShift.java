package vehicleShop.models.worker;

public class FirstShift extends BaseWorker{


    private final static int STRENGTH_FS = 100;

    public FirstShift(String name) {
        super(name, STRENGTH_FS);
    }
}
