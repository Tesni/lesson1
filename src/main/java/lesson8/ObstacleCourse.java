package lesson8;

import lesson8.moving.objects.MovingObject;
import lesson8.moving.objects.impl.Cat;
import lesson8.moving.objects.impl.Human;
import lesson8.moving.objects.impl.Robot;
import lesson8.moving.obstacles.Obstacle;
import lesson8.moving.obstacles.impl.Treadmill;
import lesson8.moving.obstacles.impl.Wall;

public class ObstacleCourse {
    public static void main(String[] args) {
        MovingObject[] participants = {
                new Cat("Кот Барсик"),
                new Robot("Андроид Вениамин"),
                new Human("Сторож Сеня")
        };

        Obstacle[] obstacles = {
                new Treadmill(5000),
                new Wall(2.0f),
                new Treadmill(10000),
                new Wall(3.0f),
                new Treadmill(20000)
        };

        for (MovingObject participant : participants) {
            try {
                for (Obstacle obstacle : obstacles) {
                    obstacle.overcome(participant);
                }
                System.out.println(participant.getName() + " - молодец!");
            } catch (RuntimeException e) {
                System.out.println(e.getLocalizedMessage());
            }
        }
    }
}
