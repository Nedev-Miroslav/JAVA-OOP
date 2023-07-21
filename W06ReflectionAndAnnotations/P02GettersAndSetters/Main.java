package W06ReflectionAndAnnotations.P02GettersAndSetters;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {


        Class<W06ReflectionAndAnnotations.P03HighQualityMistakes.Reflection> clazz = W06ReflectionAndAnnotations.P03HighQualityMistakes.Reflection.class;

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

        for (Method getter : getters) {
            System.out.printf("%s will return class %s%n", getter.getName(), getter.getReturnType().getName());
        }

        for (Method setter : setters) {
            System.out.printf("%s and will set field of class %s%n", setter.getName(), setter.getParameterTypes()[0].getName());
        }

    }
}
