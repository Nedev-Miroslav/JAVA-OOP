package W06ExercisesReflection.P03BarracksWarsANewFactory.barracksWars.interfaces;

import W06ExercisesReflection.P04BarracksWarsTheCommandsStrikeBack.barracksWars.interfaces.Executable;

public interface CommandInterpreter {

	Executable interpretCommand(String[] data, String commandName);
}
