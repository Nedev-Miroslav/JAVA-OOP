package W09DesignPatterns.P06StrategyDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Person> people = new ArrayList<>();
        people.add(new Person("Pesho", "Petrov"));
        people.add(new Person("Andrei", "Todorov"));
        people.add(new Person("Viktor", "Ivanov"));
        people.add(new Person("Ivan", "Nikolov"));
        people.add(new Person("Georgi", "Popov"));

        PersonFirstNameComparator comp1 = new PersonFirstNameComparator();
        people.sort(comp1);


        PersonLastNameComparator comp2 = new PersonLastNameComparator();
        people.sort(comp2);

        // Идеята на Strategy Pattern е функционалност която може да бъде изпълнена по различни начини
        // В случая имаме сортиране което може да се изпълни по различен начин в зависимост от
        // имплементацията на Comparator
    }
}
