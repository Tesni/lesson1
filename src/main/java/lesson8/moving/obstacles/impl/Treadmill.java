package lesson8.moving.obstacles.impl;

import lesson8.moving.objects.MovingObject;
import lesson8.moving.obstacles.Obstacle;

public class Treadmill implements Obstacle {
    private int distance;

    public Treadmill(int distance) {
        this.distance = distance;
    }

    @Override
    public void overcome(MovingObject movingObject) {
        System.out.print("Дорожка длиной " + this.distance + " м! ");
        movingObject.run(this.distance);
    }
}
