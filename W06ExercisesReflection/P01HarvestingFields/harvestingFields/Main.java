package W06ExercisesReflection.P01HarvestingFields.harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Class<RichSoilLand> clazz = RichSoilLand.class;

		Field [] field = clazz.getDeclaredFields();

		String command = scanner.nextLine();

		while (!"HARVEST".equals(command)){

			for (Field field1 : field) {

				if (Modifier.toString(field1.getModifiers()).equals(command)) {
					System.out.printf("%s %s %s%n", Modifier.toString(field1.getModifiers()), field1.getType().getSimpleName(), field1.getName() );

				} else if (command.equals("all")) {
					System.out.printf("%s %s %s%n", Modifier.toString(field1.getModifiers()), field1.getType().getSimpleName(), field1.getName() );
				}


			}


			command = scanner.nextLine();
		}


	}
}
