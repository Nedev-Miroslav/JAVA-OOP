package W06ExercisesReflection.P03BarracksWarsANewFactory.barracksWars.models.units;

import W06ExercisesReflection.P04BarracksWarsTheCommandsStrikeBack.barracksWars.models.units.AbstractUnit;

public class Pikeman extends AbstractUnit {

	private static final int PIKEMAN_HEALTH = 30;
	private static final int PIKEMAN_DAMAGE = 15;

	public Pikeman() {
		super(PIKEMAN_HEALTH, PIKEMAN_DAMAGE);
	}
}
