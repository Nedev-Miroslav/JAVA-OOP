package football.core;


import football.common.ConstantMessages;
import football.common.ExceptionMessages;
import football.entities.field.ArtificialTurf;
import football.entities.field.Field;
import football.entities.field.NaturalGrass;
import football.entities.player.Men;
import football.entities.player.Player;
import football.entities.player.Women;
import football.entities.supplement.Liquid;
import football.entities.supplement.Powdered;
import football.entities.supplement.Supplement;
import football.repositories.SupplementRepository;
import football.repositories.SupplementRepositoryImpl;

import java.util.ArrayList;
import java.util.Collection;

public class ControllerImpl implements Controller {

    private SupplementRepository supplement;
    private Collection<Field> fields;

    public ControllerImpl() {
        this.supplement = new SupplementRepositoryImpl();
        this.fields = new ArrayList<>();
    }

    @Override
    public String addField(String fieldType, String fieldName) {
        Field field = null;

        if (fieldType.equals("ArtificialTurf")) {
            field = new ArtificialTurf(fieldName);
        } else if (fieldType.equals("NaturalGrass")) {
            field = new NaturalGrass(fieldName);
        } else {
            throw new NullPointerException(ExceptionMessages.INVALID_FIELD_TYPE);
        }

        fields.add(field);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_FIELD_TYPE, fieldType);
    }

    @Override
    public String deliverySupplement(String type) {
        Supplement currentSupplement = null;

        if (type.equals("Powdered")) {
            currentSupplement = new Powdered();
        } else if (type.equals("Liquid")) {
            currentSupplement = new Liquid();
        } else {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_SUPPLEMENT_TYPE);
        }
        supplement.add(currentSupplement);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_FIELD_TYPE, type);
    }

    @Override
    public String supplementForField(String fieldName, String supplementType) {
        Supplement currentSupplement = this.supplement.findByType(supplementType);
        if (currentSupplement == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.NO_SUPPLEMENT_FOUND, supplementType));
        }

        Field field = getFieldByName(fieldName);
        field.addSupplement(currentSupplement);
        this.supplement.remove(currentSupplement);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_SUPPLEMENT_IN_FIELD, supplementType, fieldName);
    }

    private Field getFieldByName(String fieldName) {
        return this.fields.stream()
                .filter(f -> f.getName().equals(fieldName))
                .findFirst()
                .get();
    }

    @Override
    public String addPlayer(String fieldName, String playerType, String playerName, String nationality, int strength) {
        Player player = null;

        if(playerType.equals("Men")){
            player = new Men(playerName, nationality, strength);
        } else if (playerType.equals("Women")) {
            player = new Women(playerName, nationality, strength);
        } else {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_PLAYER_TYPE);
        }
        Field field = getFieldByName(fieldName);

        boolean checkMen = (playerType.equals("Men") && field.getClass().getSimpleName().equals("NaturalGrass"));
        boolean checkWomen = (playerType.equals("Women") && field.getClass().getSimpleName().equals("ArtificialTurf"));

        if(checkMen || checkWomen){
            field.addPlayer(player);
        } else {
            return ConstantMessages.FIELD_NOT_SUITABLE;
        }

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_PLAYER_IN_FIELD, playerType, fieldName);
    }

    @Override
    public String dragPlayer(String fieldName) {
       Field field = getFieldByName(fieldName);
       field.drag();

        return String.format(ConstantMessages.PLAYER_DRAG, field.getPlayers().size());
    }

    @Override
    public String calculateStrength(String fieldName) {
        Field field = getFieldByName(fieldName);
        int playerStrength = field.getPlayers().stream().mapToInt(Player::getStrength).sum();

        return String.format(ConstantMessages.STRENGTH_FIELD, fieldName, playerStrength);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        for (Field field : fields) {
            sb.append(field.getInfo()).append(System.lineSeparator());
        }

        return sb.toString().trim();

    }
}
