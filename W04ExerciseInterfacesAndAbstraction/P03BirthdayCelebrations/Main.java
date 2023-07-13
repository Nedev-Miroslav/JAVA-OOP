package W04ExerciseInterfacesAndAbstraction.P03BirthdayCelebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<Birthable> list = new ArrayList<>();

        while (!"End".equals(input)){

          String [] token = input.split("\\s+");
          String current = token[0];

          if ("Pet".equals(current)){
              String name = token[1];
              String birthday = token[2];

              Pet pet = new Pet(name, birthday);
              list.add(pet);
          } else if ("Citizen".equals(current)){
              String name = token[1];
              int age = Integer.parseInt(token[2]);
              String id = token[3];
              String birthDay = token[4];
              Citizen citizen = new Citizen(name, age, id, birthDay);

              list.add(citizen);
          }



            input = scanner.nextLine();
        }

        String dateToCheck = scanner.nextLine();


            boolean isMatchADate = false;
        for (Birthable s : list) {
            if (s.getBirthDate().endsWith(dateToCheck)) {
                System.out.println(s.getBirthDate());
                isMatchADate = true;
            }
        }
        if (!isMatchADate){
            System.out.println("<no output>");

            }



    }


}
