package lesson14;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArrayProcessorTest {

    ArrayProcessor arrayProcessor = new ArrayProcessor();

    @Test
    public void checkIfContainsOneAndFourTestPositive() {
        int[] incArr = new int[] {1,4,1,1,4,1,4};
        Assertions.assertTrue(arrayProcessor.checkIfContainsOneAndFour(incArr));

        incArr = new int[] {1,1,1,1,4};
        Assertions.assertTrue(arrayProcessor.checkIfContainsOneAndFour(incArr));

        incArr = new int[] {4,4,4,4,4,1,4,4,4,4,4};
        Assertions.assertTrue(arrayProcessor.checkIfContainsOneAndFour(incArr));

        incArr = new int[] {1,4};
        Assertions.assertTrue(arrayProcessor.checkIfContainsOneAndFour(incArr));
    }

    @Test
    public void checkIfContainsOneAndFourTestNegative() {
        int[] incArr = new int[] {1,1,1,1,1,1,1};
        Assertions.assertFalse(arrayProcessor.checkIfContainsOneAndFour(incArr));

        incArr = new int[] {4,4,4,4,4};
        Assertions.assertFalse(arrayProcessor.checkIfContainsOneAndFour(incArr));

        incArr = new int[] {};
        Assertions.assertFalse(arrayProcessor.checkIfContainsOneAndFour(incArr));

        incArr = new int[] {1,4,3,1,4,4,1,4};
        Assertions.assertFalse(arrayProcessor.checkIfContainsOneAndFour(incArr));
    }
}
