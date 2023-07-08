package W01ExerciseWorkingWithAbstraction.P04TrafficLights;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(scanner.nextLine());


        List<TrafficLight> trafficLights = Arrays.stream(input).map(Color::valueOf)
                .map(TrafficLight::new)
                .collect(Collectors.toList());


        for (int i = 0; i < n; i++) {
            for (TrafficLight light : trafficLights) {
                light.changeColor();
                System.out.print(light.getColor() + " ");
            }
            System.out.println();
        }


    }
}