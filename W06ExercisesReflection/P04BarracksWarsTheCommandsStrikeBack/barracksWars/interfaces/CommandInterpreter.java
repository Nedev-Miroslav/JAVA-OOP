package W06ExercisesReflection.P04BarracksWarsTheCommandsStrikeBack.barracksWars.interfaces;

public interface CommandInterpreter {

	Executable interpretCommand(String[] data, String commandName);
}
