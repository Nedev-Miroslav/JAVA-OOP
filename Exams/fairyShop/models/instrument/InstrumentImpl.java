package fairyShop.models.instrument;

import fairyShop.common.ExceptionMessages;

public class InstrumentImpl implements Instrument{

    private int power;

    public InstrumentImpl(int power) {
        this.setPower(power);
    }


    @Override
    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        if(power < 0){
            throw new IllegalArgumentException(ExceptionMessages.INSTRUMENT_POWER_LESS_THAN_ZERO);
        }

        this.power = power;
    }

    @Override
    public void use() {
        if(this.getPower() - 10 > 0){
            this.setPower(this.getPower() - 10);
        } else {
            this.setPower(0);
        }
    }

    @Override
    public boolean isBroken() {
        return this.getPower() <= 0;
    }
}
