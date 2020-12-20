package lesson7;

public class CatsAndPlates {

    public static void main(String[] args) {
        Cat[] cats = {
                new Cat("Саймон"),
                new Cat("Барсик"),
                new Cat("Том")
        };
        Plate plate = new Plate();
        plate.addFood(9);

        for (Cat cat : cats) {
            cat.eat(plate);
        }
        for (Cat cat : cats) {
            System.out.println(cat);
        }
    }


}
