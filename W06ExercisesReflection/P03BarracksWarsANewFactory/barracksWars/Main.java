package W06ExercisesReflection.P03BarracksWarsANewFactory.barracksWars;

import W06ExercisesReflection.P04BarracksWarsTheCommandsStrikeBack.barracksWars.interfaces.Repository;
import W06ExercisesReflection.P04BarracksWarsTheCommandsStrikeBack.barracksWars.interfaces.Runnable;
import W06ExercisesReflection.P04BarracksWarsTheCommandsStrikeBack.barracksWars.interfaces.UnitFactory;
import W06ExercisesReflection.P04BarracksWarsTheCommandsStrikeBack.barracksWars.core.Engine;
import W06ExercisesReflection.P04BarracksWarsTheCommandsStrikeBack.barracksWars.core.factories.UnitFactoryImpl;
import W06ExercisesReflection.P04BarracksWarsTheCommandsStrikeBack.barracksWars.data.UnitRepository;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}
