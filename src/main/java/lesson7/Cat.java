package lesson7;

import java.util.Random;

public class Cat {
    private String name;
    private boolean isFull = false;

    public Cat(String name) {
        this.name = name;
    }

    public boolean eat(Plate plate) {
        try {
            plate.decreaseFood(new Random().nextInt(4) + 3);
            isFull = true;
        } catch (RuntimeException e) {
            System.out.println("Коту " + name + " не хватило еды в тарелке.");
        }
        return isFull;
    }

    @Override
    public String toString() {
        return name + " " + (isFull ? "сыт" : "голоден");
    }
}
