package lesson11.fruits;

public abstract class Fruit {
    private float weight;

    public Fruit(float weight) {
        this.weight = weight;
    }

    public float getWeight() {
        return this.weight;
    }
}
