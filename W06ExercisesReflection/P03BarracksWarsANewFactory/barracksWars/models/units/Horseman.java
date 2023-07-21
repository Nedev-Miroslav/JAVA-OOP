package W06ExercisesReflection.P03BarracksWarsANewFactory.barracksWars.models.units;

import W06ExercisesReflection.P04BarracksWarsTheCommandsStrikeBack.barracksWars.models.units.AbstractUnit;

public class Horseman extends AbstractUnit {
    private static final int HORSEMAN_HEALTH = 50;
    private static final int HORSEMAN_DAMAGE = 10;

    public Horseman() {
        super(HORSEMAN_HEALTH, HORSEMAN_DAMAGE);
    }

    public Horseman(int health, int attackDamage) {
        super(health, attackDamage);
    }
}

