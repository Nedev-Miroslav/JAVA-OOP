package fairyShop.core;

import fairyShop.common.ConstantMessages;
import fairyShop.common.ExceptionMessages;
import fairyShop.models.helper.Happy;
import fairyShop.models.helper.Helper;
import fairyShop.models.helper.Sleepy;
import fairyShop.models.instrument.Instrument;
import fairyShop.models.instrument.InstrumentImpl;
import fairyShop.models.present.Present;
import fairyShop.models.present.PresentImpl;
import fairyShop.models.shop.Shop;
import fairyShop.models.shop.ShopImpl;
import fairyShop.repositories.HelperRepository;
import fairyShop.repositories.PresentRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller{

        private HelperRepository helperRepository;
        private PresentRepository presentRepository;
        private int countMadePresents;


    public ControllerImpl() {
        this.helperRepository = new HelperRepository();
        this.presentRepository = new PresentRepository();
        this.countMadePresents = 0;
    }

    @Override
    public String addHelper(String type, String helperName) {
        Helper helper = null;

        if(type.equals("Happy")){
            helper = new Happy(helperName);
        } else if (type.equals("Sleepy")) {
            helper = new Sleepy(helperName);
        } else {
            throw new IllegalArgumentException(ExceptionMessages.HELPER_TYPE_DOESNT_EXIST);
        }


        helperRepository.add(helper);


        return String.format(ConstantMessages.ADDED_HELPER, type, helperName);
    }

    @Override
    public String addInstrumentToHelper(String helperName, int power) {
        Helper helper = helperRepository.findByName(helperName);

        if(helper == null) {
            throw new IllegalArgumentException(ExceptionMessages.HELPER_DOESNT_EXIST);
        }
        Instrument instrument = new InstrumentImpl(power);
        helper.addInstrument(instrument);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_INSTRUMENT_TO_HELPER, power, helperName);
    }

    @Override
    public String addPresent(String presentName, int energyRequired) {
        Present present = new PresentImpl(presentName, energyRequired);
        presentRepository.add(present);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_PRESENT, presentName);

    }

    @Override
    public String craftPresent(String presentName) {
        List<Helper> availableHelper = helperRepository.getModels().stream()
                .filter(h -> h.getEnergy() > 50)
                .collect(Collectors.toList());

        if(availableHelper.isEmpty()){
            throw new IllegalArgumentException(ExceptionMessages.NO_HELPER_READY);
        }

        Present present = presentRepository.findByName(presentName);
        Shop shop = new ShopImpl();
        int brokenInstrument = 0;

        while (!availableHelper.isEmpty() && !present.isDone()){
            Helper helper = availableHelper.get(0);
            shop.craft(present, helper);
            brokenInstrument += helper.getInstruments().stream().filter(Instrument::isBroken).count();

            if(!helper.canWork() || helper.getInstruments().stream().noneMatch(i -> !i.isBroken())) {
                availableHelper.remove(helper);
            }

        }

        if(present.isDone()){
            countMadePresents++;
            return String.format(ConstantMessages.PRESENT_DONE, present.getName(), "done")
                   + String.format(ConstantMessages.COUNT_BROKEN_INSTRUMENTS, brokenInstrument);

        } else {
            return String.format(ConstantMessages.PRESENT_DONE, present.getName(), "not done")
                    + String.format(ConstantMessages.COUNT_BROKEN_INSTRUMENTS, brokenInstrument);
        }


    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%d presents are done!", countMadePresents)).append(System.lineSeparator());
        sb.append("Helpers info:").append(System.lineSeparator());

        for (Helper model : helperRepository.getModels()) {
            long leftInstrument = model.getInstruments().stream().filter(i -> i.getPower() > 0).count();
            sb.append(String.format("Name: %s", model.getName())).append(System.lineSeparator());
            sb.append(String.format("Energy: %d", model.getEnergy())).append(System.lineSeparator());
            sb.append(String.format("Instruments: %d not broken left", leftInstrument)).append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}


