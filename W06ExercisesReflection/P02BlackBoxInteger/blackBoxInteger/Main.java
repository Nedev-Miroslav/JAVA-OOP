package W06ExercisesReflection.P02BlackBoxInteger.blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Scanner scanner = new Scanner(System.in);

        Class<BlackBoxInt> clazz = BlackBoxInt.class;

        Constructor<BlackBoxInt> ctor = clazz.getDeclaredConstructor();
        ctor.setAccessible(true);
        BlackBoxInt blackBoxInt = ctor.newInstance();

        Field field = clazz.getDeclaredField("innerValue");
        field.setAccessible(true);



        String command = scanner.nextLine();

        while (!"END".equals(command)) {

            String commandName = command.split("_")[0];
            int number = Integer.parseInt(command.split("_")[1]);

            Method method = clazz.getDeclaredMethod(commandName, int.class);
            method.setAccessible(true);
            method.invoke(blackBoxInt, number);

            System.out.println(field.get(blackBoxInt));

            command = scanner.nextLine();
        }

    }
}
