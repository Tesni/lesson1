package lesson2;


import java.util.Arrays;

public class Application2 {
    public static void main(String[] args) {
        int[] numbers = { 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 };

        // Задание 1
        for (int i = 0; i < numbers.length; i++) {
             numbers[i] = numbers[i] == 1 ? 0 : 1;
        }
        printArray(numbers);

        // Задание 2
        int[] multiple3 = new int[8];
        for (int i = 0; i < 8; i++ ) {
            multiple3[i] = i*3;
        }
        printArray(multiple3);

        // Задание 3
        numbers = new int[]{ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };

        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            if (number < 6) {
                numbers[i] = number*2;
            }
        }
        printArray(numbers);

        // Задание 4
        int [][] twoDimensionnumbers = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == j) {
                    twoDimensionnumbers[i][j] = 1;
                } else {
                    twoDimensionnumbers[i][j] = 0;
                }
            }
        }
        printTwoDimensionArray(twoDimensionnumbers);

        // Задание 5
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int number : numbers) {
            if (number > max) {
                max = number;
            }
            if (number < min) {
                min = number;
            }
        }
        System.out.println("Максимальное число в массиве - " + max + ", минимальное - " + min);

        System.out.println(checkBalance(new int[] {2, 2, 2, 1, 2, 2, 10, 1}));

        printArray(rotateElementsOfArray(numbers, 2));
        printArray(rotateElementsOfArray(numbers, 12));
    }

    /**
     * Задание 6
     * @param numbers - целочисленный массив
     * @return true - в случае, если можно поделить на две равные части (в каком-то месте массива)
     */
    public static boolean checkBalance(int[] numbers) {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum % 2 == 0;
    }

    /**
     * Задание 7
     * @param array - массив (в примере - целочисленный, но, по сути, не важно)
     * @param steps - количество шагов, на которые происходит смещение элементов массива
     * @return Массив со смещёнными на steps шагов элементами
     */
    public static int[] rotateElementsOfArray(int[] array, int steps) {
        int effectiveSteps = steps % array.length;
        if (effectiveSteps != 0) {
            for (int i = 0; i < effectiveSteps; i++) {
                int temp = array[0];
                for (int j = 0; j < array.length; j++) {
                    if (j + 1 < array.length) {
                        array[j] = array[j + 1];
                    } else {
                        array[array.length - 1] = temp;
                    }
                }
            }
        }
        return array;
    }

    public static void printArray(int [] numbers) {
        System.out.println(Arrays.toString(numbers));
    }

    public static void printTwoDimensionArray(int[][] array) {
        for (int[] subarr : array) {
            printArray(subarr);
        }
    }
}
