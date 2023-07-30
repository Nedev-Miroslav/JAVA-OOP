package W09DesignPatterns.P06StrategyDesignPattern;

import java.util.Collections;
import java.util.Comparator;

public class PersonFirstNameComparator implements Comparator<Person> {


    // Това е логиката на компаратора ще подреди имената по азбучан ред
    @Override
    public int compare(Person left, Person right) {
        return left.getFirstName().compareTo(right.getLastName());
    }

    // С този метод ще получим подредени имената в обратен ред
    public Comparator<Person> reversed(){
        return Collections.reverseOrder(this);
    }
}
