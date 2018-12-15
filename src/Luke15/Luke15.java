package Luke15;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Luke15 {

    public static void main (String args[]) throws FileNotFoundException {
        File file = new File("./src/Luke15/inputLuke15.txt");
        Scanner sc = new Scanner(file);

        System.out.println("Number of people with gullbursdag: " + findPplWithGullbursdag(sc));
    }

    private static int findPplWithGullbursdag(Scanner sc) {
        int pplWithGullbursdag = 0;

        while (sc.hasNextLine()) {
            String[] line = sc.nextLine().split("\\.");
            int yearOfBirth = Integer.parseInt(line[1]);

            if (hasGullbursdag(yearOfBirth)) {
                pplWithGullbursdag++;
            }
        }
        return pplWithGullbursdag;
    }

    private static boolean hasGullbursdag(int yearOfBirth) {
        boolean hasGullbursdag = true;
        int yearCounter = yearOfBirth;
        int ageounter = 0;
        while (hasGullbursdag) {
            yearCounter++;
            ageounter++;

            if (ageounter*ageounter == yearCounter) {
                return hasGullbursdag;
            } else if (ageounter*2 > yearCounter) {
                hasGullbursdag = false;
            }
        }
        return hasGullbursdag;
    }
}
