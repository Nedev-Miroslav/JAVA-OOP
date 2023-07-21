package W06ExercisesReflection.P03BarracksWarsANewFactory.barracksWars.interfaces;

import W06ExercisesReflection.P04BarracksWarsTheCommandsStrikeBack.barracksWars.interfaces.Unit;
import jdk.jshell.spi.ExecutionControl;

public interface UnitFactory {

    Unit createUnit(String unitType) throws ExecutionControl.NotImplementedException;
}