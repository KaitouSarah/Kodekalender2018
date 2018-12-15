package Luke6;

public class Luke6 {

    final static int limit = 18163106;
    static long sumNulltungeTall =  0L;

    public static void main (String args[]) {
        for (int i = 1; i < limit+1; i++) {
            if (isNulltung(i)) {
                sumNulltungeTall+=i;
            }
        }
        System.out.println("Sum av alle nulltunge tall fra 1 tom 18 163 106: " + sumNulltungeTall);
    }

    public static boolean isNulltung (int number) {
        int zero = 0;
        int notZero = 0;

        while (number > 0) {
            if (number % 10 == 0) {
                zero++;
            } else {
                notZero++;
            }
            number = number / 10;
        }
        return zero > notZero;
    }
}
