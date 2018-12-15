package Luke11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Luke11 {
    public static void main (String args[]) {
        int y = 0;
        int x = 0;
        File file = new File("./src/Luke11/inputLuke11.txt");
        Scanner sc;

        try {
            sc = new Scanner(file).useDelimiter("");

            while (sc.hasNext()) {
                int number = sc.nextInt();
                Character direction = sc.next().charAt(0);
                if (direction == 'H') {
                    x += number;
                } else if (direction.equals('V')) {
                    x -= number;
                } else if (direction.equals('F')) {
                    y += number;
                } else if (direction.equals('B')) {
                    y -= number;
                } else {
                    System.out.println("Something went horribly wrong!");
                }
             }

            System.out.println("Gavene er på koordinatene [" + x + "," + y + "]");
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
