package Luke6;
/*
Nulltunge tall
~~~~~~~~~~~~~~~~~~
Nulltunge tall er heltall som har flere nuller i seg enn de andre sifferene til sammen. For eksempel er 1050006 nulltungt, og 105006 er ikke.
Hva er summen av alle nulltunge tall fra og med 1 til og med 18 163 106?
 */
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
