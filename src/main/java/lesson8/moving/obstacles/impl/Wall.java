package lesson8.moving.obstacles.impl;

import lesson8.moving.objects.MovingObject;
import lesson8.moving.obstacles.Obstacle;

public class Wall implements Obstacle {
    private float height;

    public Wall(float height) {
        this.height = height;
    }

    @Override
    public void overcome(MovingObject movingObject) {
        System.out.print("Стена высотой " + this.height + " м! ");
        movingObject.jump(this.height);
    }
}
