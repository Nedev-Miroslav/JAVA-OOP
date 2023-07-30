package W09DesignPatterns.P02PrototypeDesignPatternDEMO;

class EmployeeRecord  implements Prototype{
    private int id;
    private String name;
    private String designation;
    private double salary;
    private String address;

    public EmployeeRecord() {
        System.out.println("Files of the employees of the Ministry of Interior Sofia: ");
        System.out.println("---------------------------------------------------------");
        System.out.println("Id" + "\t" + "Name" + "\t" + "Designation" + "\t\t" + "Salary" + "\t\t" + "Address");
    }

    public EmployeeRecord(int id, String name, String designation, double salary, String address) {
        this();
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.salary = salary;
        this.address = address;
    }

    public void showRecord() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "EmployeeRecord{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", designation='" + designation + '\'' +
                ", salary=" + salary +
                ", address='" + address + '\'' +
                '}';
    }

    // С Override пренаписваме метода който идва от Prototype интерфейса и с него връщаме една нова инстанция която обаче
    // ще има същите полета и въщите данни като първоначално създадения обект
    @Override
    public Prototype clone() {
        return new EmployeeRecord(id, name, designation, salary, address);
    }
}