package lesson8.moving.objects.impl;

import lesson8.moving.MovingUtils;
import lesson8.moving.objects.MovingObject;

public class Cat implements MovingObject {
    private final String name;
    private final int runDistance;
    private final float jumpHeight;

    public Cat(String name) {
        this.name = name;
        this.runDistance = (int) MovingUtils.randomizeVariable(5000, 0.9f);
        this.jumpHeight = MovingUtils.randomizeVariable(2.5f, 0.5f);
    }

    @Override
    public void run(float distance) {
        if (distance > this.runDistance) {
            throw new RuntimeException(this.name + ": Ой, фсё!");
        } else {
            System.out.println(this.name + " успешно пробежал дистанцию. (Запас хода: " + this.runDistance + ")");
        }
    }

    @Override
    public void jump(float height) {
        if (height > this.jumpHeight) {
            throw new RuntimeException(this.name + ": Ой, фсё!");
        } else {
            System.out.println(this.name + " успешно перепрыгнул. (Высота прыжка: " + this.jumpHeight + ")");
        }
    }

    @Override
    public String getName() {
        return this.name;
    }
}
