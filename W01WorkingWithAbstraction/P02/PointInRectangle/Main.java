package W01WorkingWithAbstraction.P02.PointInRectangle;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] input = scanner.nextLine().split("\\s+");

        int bottomLeftX = Integer.parseInt(input[0]);
        int bottomLeftY = Integer.parseInt(input[1]);
        int topRightX = Integer.parseInt(input[2]);
        int topRightY = Integer.parseInt(input[3]);

        int n = Integer.parseInt(scanner.nextLine());

        Point point1 = new Point(bottomLeftX, bottomLeftY);
        Point point2 = new Point(topRightX, topRightY);
        Rectangle rectangle = new Rectangle(point1, point2);

        for (int i = 1; i <= n; i++) {

            String [] inputPoints = scanner.nextLine().split("\\s+");

            int pointX = Integer.parseInt(inputPoints[0]);
            int pointY = Integer.parseInt(inputPoints[1]);
            Point currentCheckPoint = new Point(pointX, pointY);

            System.out.println(rectangle.contains(currentCheckPoint));


        }


    }
}
