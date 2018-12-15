package Luke14;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

@SuppressWarnings("Duplicates")
public class Luke14 {
    public static void main (String args[]) throws FileNotFoundException {

        File file = new File("./src/Luke14/inputLuke14.txt");
        Scanner sc = new Scanner(file).useDelimiter("");
        int currentX = 0;
        int currentY = 0;
        int highestX = 0;
        int lowestX = 0;
        int highestY = 0;
        int lowestY = 0;
        int length;
        int height;
        double answer = 0;
        ArrayList<Coordinates> coordinatesList = new ArrayList();
        Coordinates coordinates;
        coordinates = new Coordinates(currentX, currentY);
        coordinatesList.add(coordinates);


        while (sc.hasNext()) {
            int number = sc.nextInt();
            Character direction = sc.next().charAt(0);
            for (int i = 0; i < number; i++) {
                if (direction == 'H') {
                    currentX ++;
                } else if (direction.equals('V')) {
                    currentX --;
                } else if (direction.equals('F')) {
                    currentY ++;
                } else if (direction.equals('B')) {
                    currentY --;
                } else {
                    System.out.println("Something went horribly wrong!");
                }
                if (currentX < lowestX) {
                    lowestX = currentX;
                } else if (currentX > highestX) {
                    highestX = currentX;
                }

                if (currentY < lowestY) {
                    lowestY = currentY;
                } else if (currentY > highestY) {
                    highestY = currentY;
                }

                boolean isVisited = false;
                for (int j = 0; j < coordinatesList.size(); j++) {
                    if (coordinatesList.get(j).getX() == currentX && coordinatesList.get(j).getY() == currentY) {
                        isVisited = true;
                    }
                }
                if (!isVisited) {
                    coordinatesList.add(new Coordinates(currentX, currentY));
                }
            }
        }

        length = highestX - lowestX + 1;
        height = highestY - lowestY + 1;
        answer = ((double)coordinatesList.size() / (double)(length * height - coordinatesList.size()));
        System.out.printf("Answer: %.16f", answer);
    }


}
