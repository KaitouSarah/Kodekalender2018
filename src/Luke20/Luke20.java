package Luke20;

import java.util.ArrayList;
import java.util.Arrays;

/*
Ok, so this code is not ideal. It's almost three in the morning, I just wanted
to do this quickly before I went to bed. And I also tried out some refactoring-techniques
since we recenty had a course on that in school.
*/

public class Luke20 {
    public static void main(String[] args) {

        System.out.println(concatenateLargestValue());
    }


    private static String concatenateLargestValue() {
        ArrayList<Integer> listOfInts = makeListOfInts(); //List of ints from puzzle
        ArrayList<String> listOfStrings = makeListOfStrings(listOfInts); //Convert list of ints to Strings
        String nextString;
        String finalNumberString = "";

        while (!listOfStrings.isEmpty()) {
            nextString = findNextNumberToAdd(listOfStrings);
            finalNumberString += nextString;
            listOfStrings.remove(nextString);
        }
        return finalNumberString;
    }

    private static String findNextNumberToAdd(ArrayList<String> listOfStrings) {
        String savedString = listOfStrings.get(0);
        for (int i = 1; i < listOfStrings.size(); i++) {
            int savedPlusIndex = Integer.parseInt(savedString + listOfStrings.get(i));
            int indexPlusSaved = Integer.parseInt((listOfStrings.get(i) + savedString));
            if (indexPlusSaved > savedPlusIndex) {
                savedString = listOfStrings.get(i);
            }
        }

        return savedString;
    }
    //Makes the list of integers given from the puzzle
    private static ArrayList<Integer> makeListOfInts() {
        ArrayList<Integer> listOfInts = new ArrayList<>(Arrays.asList(7096, 3, 3924, 2404, 4502,
                4800, 74, 91, 9, 7, 9, 6790, 5, 59, 9, 48, 6345, 88, 73, 88, 956, 94, 665, 7,
                797, 3978, 1, 3922, 511, 344, 6, 10, 743, 36, 9289, 7117, 1446, 10, 7466, 9,
                223, 2, 6, 528, 37, 33, 1616, 619, 494, 48, 9, 5106, 144, 12, 12, 2, 759, 813,
                5156, 9779, 969, 3, 257, 3, 4910, 65, 1, 907, 4464, 15, 8685, 54, 48, 762, 7952,
                639, 3, 4, 8239, 4, 21, 306, 667, 1, 2, 90, 42, 6, 1, 3337, 6, 803, 3912, 85,
                31, 30, 502, 876, 8686, 813, 880, 5309, 20, 27, 2523, 266, 101, 8, 3058, 7,
                56, 6961, 46, 199, 866, 4, 184, 4, 9675, 92));

        return listOfInts;
    }
    //Makes the list of ints into list of strings
    private static ArrayList<String> makeListOfStrings(ArrayList<Integer> listOfInts) {
        ArrayList<String> listOfString = new ArrayList<>();
        for (int i = 0; i < listOfInts.size(); i++) {
            listOfString.add(String.valueOf(listOfInts.get(i)));
        }

        return listOfString;
    }
}
