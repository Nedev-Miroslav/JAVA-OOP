package W09DesignPatterns.P03FactoryDesignPattern.Cakes;

import W09DesignPatterns.P03FactoryDesignPattern.Cake;

public class Main {
    public static void main(String[] args) {


        // Така скриваме имплементационните детайли
       CakeFactory.createCake("Choco", 12, 30, 6);
    }
}
