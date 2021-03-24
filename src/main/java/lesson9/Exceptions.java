package lesson9;

import lesson9.exceptions.MyArrayDataException;
import lesson9.exceptions.MyArraySizeException;

import java.util.HashSet;
import java.util.Set;

public class Exceptions {
    public static void main(String[] args) {
        String[][] testArr = {
                {"2", "3", "4", "5"},
                {"2", "3", "4", "5"},
                {"2", "3", "4", "5"},
                {"2", "3", "4", "5"}
        };
        String[][] testArr2 = {
                {"2", "3", "qwe", "5"},
                {"2", "3", "4", "5"},
                {"2", "ewe", "4", "5"},
                {"2", "3", "eee", null}
        };
        String[][] testArr3 = {
                {"2", "3", "4", "5"},
                {"2", "3", "4", "5"},
                {"2", "3", "4", "5", "12"},
                {"2", "3", "4", "5"}
        };

        try {
            System.out.println(sumQuadArrayValues(testArr));
        } catch (MyArrayDataException | MyArraySizeException e) {
            System.out.println(e.getLocalizedMessage());
        }
        try {
            System.out.println(sumQuadArrayValues(testArr2));
        } catch (MyArrayDataException | MyArraySizeException e) {
            System.out.println(e.getLocalizedMessage());
        }
        try {
            System.out.println(sumQuadArrayValues(testArr3));
        } catch (MyArrayDataException | MyArraySizeException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    private static int sumQuadArrayValues(String[][] stringArr) {
        if (stringArr.length != 4) {
            throw new MyArraySizeException("Размер внешнего массива отличен от 4");
        } else {
            for (String[] arr : stringArr) {
                if (arr.length != 4) {
                    throw new MyArraySizeException("Размер одного из внутренних массивов отличен от 4");
                }
            }
        }

        int sum = 0;
        Set<String> errorSet = new HashSet<>();
        for (int i = 0; i < stringArr.length; i++) {
            int subArrLength = stringArr[i].length;
            for (int j = 0; j < subArrLength; j++) {
                try {
                    sum += Integer.parseInt(stringArr[i][j]);
                } catch (NumberFormatException e) {
                    errorSet.add(i + "." + j);
                }
            }
        }

        if (errorSet.size() > 0) {
            throw new MyArrayDataException("Не удалось подсчитать сумму. Содержимое следующих ячеек невозможно привести к целому числу : " + String.join(", ",errorSet));
        }
        return sum;
    }
}
