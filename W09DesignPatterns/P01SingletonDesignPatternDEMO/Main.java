package W09DesignPatterns.P01SingletonDesignPatternDEMO;

public class Main {
    public static void main(String[] args) {

        System.out.println("Start");
        // По този начин вдигаме една инстанция и колкото и пъти да извикаме метода .getInstance()
        // Винаги ще се сочи към тази инстанция;
        DatabaseConnection read = DatabaseConnection.getInstance();
        read.readFromDB();
        read.writeToDB();
        System.out.println("End");


    }

    public static void doSomething() {

    }

}
