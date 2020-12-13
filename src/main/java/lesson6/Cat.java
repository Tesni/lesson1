package lesson6;

public class Cat extends Animal {
    public Cat() {
        super(200, 2f, 0);
    }

    @Override
    public void swim(int swimDistance) {
        throw new RuntimeException("Кошки не умеют плавать");
    }
}
