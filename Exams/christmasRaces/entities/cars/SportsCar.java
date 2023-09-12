package christmasRaces.entities.cars;

import christmasRaces.common.ExceptionMessages;

public class SportsCar extends BaseCar{
    public SportsCar(String model, int horsePower) {
        super(model, horsePower, 3000);
        checkHorsePower(horsePower);
    }


    public void checkHorsePower (int horsePower) {
        if(horsePower < 250 || horsePower > 450){
            throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_HORSE_POWER, horsePower));
        }


    }

}
