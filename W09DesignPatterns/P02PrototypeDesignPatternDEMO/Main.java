package W09DesignPatterns.P02PrototypeDesignPatternDEMO;

public class Main {
    public static void main(String[] args) {

        Prototype employee1 = new EmployeeRecord(1, "Pesho", "Manager", 10000, "Sofia");


        // Така клонираме първоначално създадения обект с метода .clone който сме имплементирали в EmployeeRecord
        // Клонираният обек ще има същите полета и информация като първоначалния, но ще бъде самостоятелен обект от този клас
        Prototype employee2 = employee1.clone();


    }

}
