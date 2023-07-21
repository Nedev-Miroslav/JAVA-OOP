package W06ExercisesReflection.P03BarracksWarsANewFactory.barracksWars.interfaces;

import W06ExercisesReflection.P04BarracksWarsTheCommandsStrikeBack.barracksWars.interfaces.Unit;
import jdk.jshell.spi.ExecutionControl;

public interface Repository {

	void addUnit(Unit unit);

	String getStatistics();

	void removeUnit(String unitType) throws ExecutionControl.NotImplementedException;
}
