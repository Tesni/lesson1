package lesson6;

import java.util.Random;

public class Animal {
    private final int runDistance;
    private final float jumpHeight;
    private final int swimDistance;

    public Animal(int runDistance, float jumpHeight, int swimDistance) {
        this.runDistance = (int) randomizeVariable(runDistance, 0.1f);
        this.jumpHeight = randomizeVariable(jumpHeight, 0.15f);
        this.swimDistance = (int) randomizeVariable(swimDistance, 0.1f);
    }

    private float randomizeVariable(float variable, float differencePercent) {
        float diffValue = variable * differencePercent;
        return (variable-diffValue) + new Random().nextFloat() * ((variable+diffValue) - (variable-diffValue));
    }

    public void run(int runDistance) {
        System.out.println("Результат: run: " + (runDistance <= this.runDistance) + ", limit: " + this.runDistance);
    }

    public void jump(int jumpHeight) {
        System.out.println("Результат: jump: " + (jumpHeight <= this.jumpHeight) + ", limit: " + this.jumpHeight);
    }

    public void swim(int swimDistance) {
        System.out.println("Результат: swim: " + (swimDistance <= this.swimDistance) + ", limit: " + this.swimDistance);
    }
}
