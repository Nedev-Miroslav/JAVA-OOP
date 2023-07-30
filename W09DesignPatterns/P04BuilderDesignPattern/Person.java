package W09DesignPatterns.P04BuilderDesignPattern;

public class Person {
    private String firstName;
    private String lastName;
    private String email;

    public Person() {
    }

    public Person(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    // Метод който връща Builder
    public static Builder builder() {
        return new Builder();
    }


    // При Builder Pattern създаваме един клас който nested (вложен)
    public static class Builder {
        // Този клас има едно поле което е класа в който е вложен Builder класът ни
        private Person person;

        // Конструкторът всеки път ще съзва нов Person
        public Builder() {
            this.person = new Person();
        }

        public Builder withFirstName(String firstName) {  // По този начин изброяваме полетата

            person.firstName = firstName;
            return this;

        }

        public Builder withLastName(String LastName) {

            person.lastName = LastName;
            return this;

        }

        public Builder withEmail(String email) {

            person.email = email;
            return this;

        }

        public Person build() {  // След като изброим полетата които сме събрали в Builder връщаме създадения Person
            validate();          // Извикваме валидацията преди да е build-нат обекта
            return person;
        }

        // поставяне на валидации за имената и email
        private void validate() {
            StringBuilder sb = new StringBuilder();

            if (person.firstName.isEmpty()) {
                sb.append("Empty firstName").append(System.lineSeparator());
            }

            if (person.lastName.isEmpty()) {
                sb.append("Empty lastName").append(System.lineSeparator());
            }

            if (person.email.isEmpty()) {
                sb.append("Empty email").append(System.lineSeparator());
            }

            if (sb.length() >= 1) {
                throw new IllegalArgumentException(sb.toString());
            }


        }


    }

}
