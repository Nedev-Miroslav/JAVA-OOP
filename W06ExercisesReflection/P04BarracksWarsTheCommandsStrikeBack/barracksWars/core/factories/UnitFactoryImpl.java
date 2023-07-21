package W06ExercisesReflection.P04BarracksWarsTheCommandsStrikeBack.barracksWars.core.factories;

import W06ExercisesReflection.P04BarracksWarsTheCommandsStrikeBack.barracksWars.interfaces.Unit;
import W06ExercisesReflection.P04BarracksWarsTheCommandsStrikeBack.barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"W06ExercisesReflection.P04BarracksWarsTheCommandsStrikeBack.barracksWars.models.units.";

	@Override
	public Unit createUnit(String unitType) throws ExecutionControl.NotImplementedException {
		try {
			Class unitClass = Class.forName(UNITS_PACKAGE_NAME + unitType);
			Constructor<Unit> constructor = unitClass.getDeclaredConstructor();
			return constructor.newInstance();
		} catch (ClassNotFoundException e){
			System.out.println(e.getMessage());
		} catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
			throw new RuntimeException(e);
		}
		return null;
	}
}
