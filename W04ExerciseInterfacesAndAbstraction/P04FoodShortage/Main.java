package W04ExerciseInterfacesAndAbstraction.P04FoodShortage;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Buyer> map = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            String input = scanner.nextLine();
            String[] inputPart = input.split("\\s+");
            if(inputPart.length == 4){
                String name = inputPart[0];
                int age = Integer.parseInt(inputPart[1]);
                String id = inputPart[2];
                String birthDate = inputPart[3];
                Citizen citizen = new Citizen(name, age, id, birthDate);
                map.put(name, citizen);

            } else if (inputPart.length == 3){
                String name = inputPart[0];
                int age = Integer.parseInt(inputPart[1]);
                String groupName = inputPart[2];
                Rebel rebel = new Rebel(name, age, groupName);
                map.put(name, rebel);
            }


        }

      String nameInput = scanner.nextLine();

        while (!"End".equals(nameInput)){

            Buyer buyer = map.get(nameInput);

            if (buyer != null){
                buyer.buyFood();
            }



            nameInput = scanner.nextLine();
        }


        System.out.println(map.values().stream().mapToInt(Buyer::getFood).sum());


    }


}
