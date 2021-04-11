package lesson14;

import java.util.Arrays;

public class ArraySplitter {

    public int[] getSubArrAfterLastFour(int[] incArr) {
        if (incArr == null || incArr.length == 0) {
            throw new RuntimeException("Invalid array state. Must be non-null, non-empty.");
        }
        Integer lastIndex = null;
        for (int i = 0; i < incArr.length; i++) {
            if (incArr[i] == 4) {
                lastIndex = i;
            }
        }
        if (lastIndex == null) {
            throw new RuntimeException("No 4 found in given incoming array: " + Arrays.toString(incArr));
        }
        return Arrays.copyOfRange(incArr, lastIndex + 1, incArr.length);
    }
}
