package W06ReflectionAndAnnotations.P03HighQualityMistakes;



import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {


        Class<Reflection> clazz = Reflection.class;

        Method[] methods = clazz.getDeclaredMethods();

        Comparator<Method> comparator = (Comparator.comparing(Method::getName));



        Set<Method> getters = new TreeSet<>(comparator);
        Set<Method> setters = new TreeSet<>(comparator);


        for (Method method : methods) {
            if(method.getName().startsWith("get")) {
                getters.add(method);
            } else if (method.getName().startsWith("set")) {
                setters.add(method);
            }


        }

        Set<Field> fields = Arrays.stream(clazz.getDeclaredFields())
                .collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Field::getName))));
        for (Field field : fields) {
            int modifier = field.getModifiers();
            if(!Modifier.isPrivate(modifier)){
                System.out.printf("%s must be private!%n", field.getName());
            }
        }

        for (Method getter : getters) {
            int modifier = getter.getModifiers();
            if (!Modifier.isPublic(modifier)){
                System.out.printf("%s have to be public!%n", getter.getName());
            }
        }

        for (Method setter : setters) {
            int modifier = setter.getModifiers();
            if (!Modifier.isPrivate(modifier)){
                System.out.printf("%s have to be private!%n", setter.getName());
            }
        }

    }
}
