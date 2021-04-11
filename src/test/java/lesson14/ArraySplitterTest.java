package lesson14;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArraySplitterTest {

    ArraySplitter arraySplitter = new ArraySplitter();

    @Test
    public void getSubArrAfterLastFourTestPositive() {
        int[] incArr = {1,2,3,4,5,6,7};
        int[] result = arraySplitter.getSubArrAfterLastFour(incArr);
        Assertions.assertEquals(3, result.length);
        Assertions.assertArrayEquals(new int[] {5,6,7}, result);
    }

    @Test
    public void getSubArrAfterLastFourTestPositiveTwoFours() {
        int[] incArr = {1,4,3,4,5,6,7};
        int[] result = arraySplitter.getSubArrAfterLastFour(incArr);
        Assertions.assertEquals(3, result.length);
        Assertions.assertArrayEquals(new int[] {5,6,7}, result);
    }

    @Test
    public void getSubArrAfterLastFourTestPositiveLastFour() {
        int[] incArr = {1,4,3,4,5,6,4};
        int[] result = arraySplitter.getSubArrAfterLastFour(incArr);
        Assertions.assertEquals(0, result.length);
        Assertions.assertArrayEquals(new int[] {}, result);
    }

    @Test
    public void getSubArrAfterLastFourTestNegativeNoFours() {
        int[] incArr = {1,2,3,5,6};
        Exception e = Assertions.assertThrows(RuntimeException.class, () ->
                arraySplitter.getSubArrAfterLastFour(incArr));
        String expectedMessage = "No 4 found in given incoming array: [1, 2, 3, 5, 6]";
        Assertions.assertTrue(e.getMessage().contains(expectedMessage));
    }

    @Test
    public void getSubArrAfterLastFourTestNegativeEmptyArray() {
        int[] incArr = {};
        Exception e = Assertions.assertThrows(RuntimeException.class, () ->
                arraySplitter.getSubArrAfterLastFour(incArr));
        String expectedMessage = "Invalid array state. Must be non-null, non-empty.";
        Assertions.assertTrue(e.getMessage().contains(expectedMessage));
    }
}
