package W06ReflectionAndAnnotations.P01Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {


        Class<W06ReflectionAndAnnotations.P03HighQualityMistakes.Reflection> clazz = W06ReflectionAndAnnotations.P03HighQualityMistakes.Reflection.class;

        System.out.println(clazz);
        System.out.println(clazz.getSuperclass());
        for (Class<?> anInterface : clazz.getInterfaces()) {
            System.out.println(anInterface);
        }

        Constructor<W06ReflectionAndAnnotations.P03HighQualityMistakes.Reflection> ctor = clazz.getDeclaredConstructor();
        W06ReflectionAndAnnotations.P03HighQualityMistakes.Reflection reflection = ctor.newInstance();
        System.out.println(reflection);

    }
}
