package W06ExercisesReflection.P03BarracksWarsANewFactory.barracksWars.models.units;

import W06ExercisesReflection.P04BarracksWarsTheCommandsStrikeBack.barracksWars.models.units.AbstractUnit;

public class Gunner extends AbstractUnit {
    private static final int GUNNER_HEALTH = 50;
    private static final int GUNNER_DAMAGE = 10;

    public Gunner() {
        super(GUNNER_HEALTH, GUNNER_DAMAGE);
    }
    public Gunner(int health, int attackDamage) {
        super(health, attackDamage);
    }
}
