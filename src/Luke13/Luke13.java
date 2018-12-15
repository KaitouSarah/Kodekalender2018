package Luke13;

import java.math.BigInteger;
import java.util.ArrayList;

public class Luke13 {

    public static void main(String args[]) {
        int numberOfEligiblePrimes = 0;
        long sumOfEligiblePrimes = 3L; //3 allerede lagt til
        int counter = 1;
        ArrayList<Integer> numberPool = new ArrayList<>();
        numberPool.add(1);
        numberPool.add(3);

        while (numberOfEligiblePrimes < 99) {
            if (distinctSum(counter, numberPool)) {
                if (isPrime(counter)) {
                    numberOfEligiblePrimes++;
                    sumOfEligiblePrimes += counter;
                    numberPool.add(counter);
                    counter++;
                } else {
                    numberPool.add(counter);
                    counter++;
                }
            } else {
                counter++;
            }
        }
        System.out.println("Sum of eligible primes: " + sumOfEligiblePrimes);
    }

    public static boolean distinctSum(int prime, ArrayList<Integer> numberPool) {
        int combinations = 0;
        int sum;
        for (int i = 0; i < numberPool.size() - 1; i++) {
            if (combinations > 1) {
                break;
            }
            for (int j = i + 1; j < numberPool.size(); j++) {
                if (combinations > 1) {
                    break;
                }
                sum = numberPool.get(i) + numberPool.get(j);
                if (sum == prime) {
                    combinations++;
                }
            }
        }
        return combinations == 1;
    }

    public static boolean isPrime(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
