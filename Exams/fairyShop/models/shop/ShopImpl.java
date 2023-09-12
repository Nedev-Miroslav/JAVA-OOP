package fairyShop.models.shop;

import fairyShop.models.helper.Helper;
import fairyShop.models.instrument.Instrument;
import fairyShop.models.present.Present;

import java.util.Collection;

public class ShopImpl implements Shop{
    @Override
    public void craft(Present present, Helper helper) {

        Collection<Instrument> instruments = helper.getInstruments();

        while (helper.canWork() && !present.isDone() && instruments.iterator().hasNext()) {

            Instrument currentInstrument = instruments.iterator().next();

            currentInstrument.use();
            helper.work();
            present.getCrafted();

            if (currentInstrument.isBroken()) {
                currentInstrument = instruments.iterator().next();
            }

        }
    }


}