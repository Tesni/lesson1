package lesson11;

import lesson11.fruits.Fruit;

import java.util.ArrayList;
import java.util.List;

/*
    Возможно, сомнительный и требующий отдельного контроля подход к учёту веса коробки,
    тем не менее он экономит время на пересчёте веса по всем элементам, поскольку вес изменяется только в процессе
    их добавления/удаления
 */
public class Box<T extends Fruit> {
    private final List<T> storage = new ArrayList<>();
    private float weight = 0f;

    public void put(T fruit) {
        this.weight += fruit.getWeight();
        this.storage.add(fruit);
    }

    public float getWeight() {
        return this.weight;
    }

    public List<T> getFruits() {
        this.weight = 0f;
        return this.storage;
    }

    public void addFruits(Box<T> box) {
        this.weight += box.getWeight();
        this.storage.addAll(box.getFruits());
    }

    public boolean compare (Box<? extends Fruit> box) {
        return this.weight == box.getWeight();
    }
}
