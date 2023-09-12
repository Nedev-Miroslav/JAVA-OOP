package vehicleShop.models.tool;

import vehicleShop.common.ExceptionMessages;

public class ToolImpl implements Tool{

    private int power;

    public ToolImpl(int power) {
        this.setPower(power);
    }


    @Override
    public int getPower() {
        return this.power;
    }

    public void setPower(int power) {
        if(power < 0){
            throw new IllegalArgumentException(ExceptionMessages.TOOL_POWER_LESS_THAN_ZERO);
        }


        this.power = power;
    }

    @Override
    public void decreasesPower() {
        if(this.getPower() - 5 > 0){
            this.setPower(this.getPower() - 5);
        } else {
            this.setPower(0);
        }

    }

    @Override
    public boolean isUnfit() {
        return this.getPower() <= 0;
    }
}
