package W09DesignPatterns.P06StrategyDesignPattern;

import java.util.Collections;
import java.util.Comparator;

public class PersonLastNameComparator implements Comparator<Person> {


    @Override
    public int compare(Person left, Person right) {
        return left.getLastName().compareTo(right.getLastName());
    }
    public Comparator<Person> reversed(){
        return Collections.reverseOrder(this);
    }
}
