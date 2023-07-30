package W09DesignPatterns.P01SingletonDesignPatternDEMO;

public class DatabaseConnection {

    private static DatabaseConnection instance;  // Поле за инстанцията

    private   DatabaseConnection(){
        try {
            Thread.sleep(4_000);  // Така симулираме бавна операция в случая отнема 4 сек.
            System.out.println("Database connection is ready!");
        } catch (InterruptedException e) {
           e.printStackTrace();
        }
    }

    public static DatabaseConnection getInstance() {  // Метод който ще връща инстанцията
        if(instance == null){
            instance = new DatabaseConnection();
        }

        return instance;
    }


    public void readFromDB(){
        System.out.println("Reading");
    }

    public void writeToDB(){
        System.out.println("Writing");
    }


}
