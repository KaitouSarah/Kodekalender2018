package Luke21;

import java.util.ArrayList;
import java.util.Arrays;

public class Luke21 {

    public static void main (String args[]) {
        ArrayList<Integer> listOfPrimes = makeListOfPrimes(1000000);
        System.out.println(listOfPrimes.size());
        ArrayList<Integer> allSandwichedRichies = findAllSandwichedRichies(listOfPrimes);
        int sumOfSandwichedRichies = sumOfNumbers(allSandwichedRichies);
        System.out.println("The sum of all sandwiched richies is " + sumOfSandwichedRichies);
    }

    private static ArrayList<Integer> findAllSandwichedRichies(ArrayList<Integer> listOfPrimes) {
        ArrayList<Integer> sandwichedRichies = new ArrayList<>();

        for (int i = 1; i < listOfPrimes.size(); i++) {
            int lastPrime = listOfPrimes.get(i-1);
            int thisPrime = listOfPrimes.get(i);
            if (thisPrime - lastPrime == 2) {
                if(isAbundantNumber(listOfPrimes.get(i) - 1)) {
                    sandwichedRichies.add(thisPrime - 1);
                }
            }
        }

        return sandwichedRichies;
    }

    private static boolean isAbundantNumber(int number) {
        ArrayList<Integer> listOfDivisors = new ArrayList<>();
        for (int i = 1; i <= number/2; i++) {
            if (number % i == 0) {
                listOfDivisors.add(i);
            }
        }
        if (productOfNumbers(listOfDivisors) > number) {
            return true;
        }
        return false;
    }

    private static int productOfNumbers(ArrayList<Integer> listOfNumbers) {
        int sum = 1;
        for (int i = 0; i < listOfNumbers.size(); i++) {
            sum *= listOfNumbers.get(i);
        }
        return sum;
    }

    private static int sumOfNumbers(ArrayList<Integer> listOfNumbers) {
        int sum = 0;
        for (int i = 0; i < listOfNumbers.size(); i++) {
            sum += listOfNumbers.get(i);
        }
        return sum;
    }

    private static ArrayList<Integer> makeListOfPrimes(int lessThan) {
        ArrayList<Integer> listOfPrimes = new ArrayList<>();
        listOfPrimes.add(2);

        for (int n = 3; n < lessThan; n += 2) {
            boolean isPrime = true;
            double sqrt = Math.sqrt(n);
            for (int i = 0; isPrime && listOfPrimes.get(i) <= sqrt; i++) {
                isPrime = n % listOfPrimes.get(i) != 0;
            }
            if (isPrime) {
                listOfPrimes.add(n);
            }
        }

        return listOfPrimes;
    }
}
