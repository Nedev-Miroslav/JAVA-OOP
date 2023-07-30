package W09DesignPatterns.P04BuilderDesignPattern;

public class Main {
    public static void main(String[] args) {

        Person.builder().withFirstName("Pesho")
                .withLastName("Peshov")
                .withEmail("Pesho@abv.bg")
                .build();

    }
}
