package W09DesignPatterns.P01SingletonDesignPatternDEMO;

public class Test {
    // Дори когата .getInstance() е извикан в различни класове отново ще сочи само към една единствена инстанция
    DatabaseConnection databaseConnection = DatabaseConnection.getInstance();
}
