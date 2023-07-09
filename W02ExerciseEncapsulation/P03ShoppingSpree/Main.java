package W02ExerciseEncapsulation.P03ShoppingSpree;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputNames = scanner.nextLine().split(";");

        LinkedHashMap<String, Person> mapPerson = new LinkedHashMap<>();
        for (String inputName : inputNames) {
            String name = inputName.split("=")[0];
            double moneyInThePocket = Double.parseDouble(inputName.split("=")[1]);
           try {
               Person person = new Person(name, moneyInThePocket);
               mapPerson.put(name, person);
           } catch (IllegalArgumentException exception){
               System.out.println(exception.getMessage());
               return;
           }


        }

        String[] inputProduct = scanner.nextLine().split(";");
        LinkedHashMap<String, Product> mapProduct = new LinkedHashMap<>();
        for (String prod : inputProduct) {
            String product = prod.split("=")[0];
            double price = Double.parseDouble(prod.split("=")[1]);
           try {
               Product product1 = new Product(product, price);
               mapProduct.put(product, product1);
           } catch (IllegalArgumentException exception){
               System.out.println(exception.getMessage());
               return;
           }


        }

        String command = scanner.nextLine();

        while (!"END".equals(command)){
            String personName = command.split("\\s+")[0];
            String productName = command.split("\\s+")[1];

            Person buyer = mapPerson.get(personName);
            Product current = mapProduct.get(productName);
           try {
               buyer.buyProduct(current);
               System.out.printf("%s bought %s%n", personName, productName);
           } catch (IllegalArgumentException exception){
               System.out.println(exception.getMessage());
           }


            command = scanner.nextLine();
        }
        mapPerson.values().forEach(System.out::println);

    }
}
