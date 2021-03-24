package lesson8.moving;

import java.util.Random;

public class MovingUtils {
    public static float randomizeVariable(float variable, float differencePercent) {
        float diffValue = variable * differencePercent;
        return (variable-diffValue) + new Random().nextFloat() * ((variable+diffValue) - (variable-diffValue));
    }
}
