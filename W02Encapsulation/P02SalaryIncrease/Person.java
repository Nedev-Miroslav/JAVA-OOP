package W02Encapsulation.P02SalaryIncrease; // Преди submit закоментирай package!

public class Person {


    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        setSalary(salary);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void increaseSalary(double increasePercent) {
        if (this.age < 30) {
            salary = salary + salary * increasePercent / 200;

        } else {
            salary = salary + salary * increasePercent / 100;
        }


    }


    @Override
    public String toString() {
        return String.format("%s %s gets %f leva.", this.getFirstName(), this.getLastName(), this.salary);
    }
}
