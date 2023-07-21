package W06ExercisesReflection.P03BarracksWarsANewFactory.barracksWars.models.units;

import W06ExercisesReflection.P04BarracksWarsTheCommandsStrikeBack.barracksWars.models.units.AbstractUnit;

public class Swordsman extends AbstractUnit {
    private static final int SWORDSMAN_HEALTH = 40;
    private static final int SWORDSMAN_DAMAGE = 13;

    public Swordsman() {
        super(SWORDSMAN_HEALTH, SWORDSMAN_DAMAGE);
    }
}
