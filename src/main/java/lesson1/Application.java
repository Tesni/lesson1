package lesson1;

public class Application {

    public static void main(String[] args) {
        byte a = 1;
        short b = 2;
        int c = 3;
        long d = 4L;
        float e = 5f;
        double f = 6.0;
        char g = 'a';
        boolean h = true;

        printPositiveOrNegative(-1);
        greet("Ксюша");
        checkIfLeapYear(400);
        checkIfLeapYear(800);
        checkIfLeapYear(300);
        checkIfLeapYear(3);

    }


    public static double calculate(float a, float b, float c, float d) {
        return a * (b + (c / d));
    }

    public static boolean checkIfBetween10And20(int x, int y) {
        return ((x + y) >= 10 && (x + y) <= 20);
    }

    public static void printPositiveOrNegative(int num) {
        /* Используем написанную после функцию
            System.out.println(
                    num < 0 ?
                            num + " - отрицательное число" :
                            num + " - положительное число"
            );
         */
        System.out.println(
                checkIfNegative(num) ?
                        num + " - отрицательное число" :
                        num + " - положительное число"
        );
    }

    public static boolean checkIfNegative(int num) {
        return num < 0;
    }

    public static void greet(String name) {
        System.out.printf("Привет, %s!\n", name);
    }

    public static void checkIfLeapYear(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            System.out.println(year + " - виоскосный год");
        } else {
            System.out.println(year + " - не високосный год.");
        }
    }
}





