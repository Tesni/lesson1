package lesson7;

public class Plate {
    private int foodQuantity = 0;

    public void addFood(int quantity) {
        if (quantity > 0) {
            this.foodQuantity += quantity;
        }
    }

    public void decreaseFood(int quantity) {
        if (foodQuantity < quantity) {
            throw new RuntimeException("В миске не хватает еды для кота");
        } else {
            this.foodQuantity -= quantity;
        }
    }

    public void printInfo() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "В тарелке " + foodQuantity + " еды.";
    }
}
