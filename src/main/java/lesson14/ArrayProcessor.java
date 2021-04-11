package lesson14;

public class ArrayProcessor {
    public boolean checkIfContainsOneAndFour(int[] incArr) {
        boolean hasOne = false;
        boolean hasFour = false;
        for (int value : incArr) {
            if (value == 1) {
                if (!hasOne) {
                    hasOne = true;
                }
            } else if (value == 4) {
                if (!hasFour) {
                    hasFour = true;
                }
            } else {
                hasFour = false;
                hasOne = false;
                break;
            }
        }
        return hasOne && hasFour;
    }
}
