package lesson11;

import lesson11.fruits.Apple;
import lesson11.fruits.Orange;

import java.util.ArrayList;
import java.util.Arrays;

public class Generics {
    public static void main(String[] args) {
        // Задание 1
        String[] names = {"Николай", "Ксения", "Вениамин"};
        System.out.println(String.join(", ", names));
        swapElements(names, 0, 2);
        System.out.println(String.join(", ", names));

        // Задание 2
        ArrayList<String> namesList = arrayToArrayList(names);
        System.out.println(String.join(", ", namesList));

        // Задание 3
        Box<Apple> appleBox = new Box<>();
        Box<Orange> orangeBox = new Box<>();
        Box<Apple> appleBox2 = new Box<>();

        appleBox.put(new Apple());
        appleBox2.put(new Apple());
        appleBox2.put(new Apple());
        orangeBox.put(new Orange());
        orangeBox.put(new Orange());

        System.out.println(appleBox.compare(orangeBox) + " = appleBox weight - " + appleBox.getWeight() +
                ", orangeBox weight - " + orangeBox.getWeight());
        appleBox.addFruits(appleBox2);
        System.out.println(appleBox.compare(orangeBox) + " = appleBox weight - " + appleBox.getWeight() +
                ", orangeBox weight - " + orangeBox.getWeight());
    }

    public static <T> T[] swapElements(T[] arr, int idx1, int idx2) {
        T temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
        return arr;
    }

    public static <T> ArrayList<T> arrayToArrayList(T... a) {
        return new ArrayList<>(Arrays.asList(a));
        /*
            Ну, или полностью повторять логику подлежащего метода, с созданием дженеризированного наследника от
            ArrayList...
         */
    }

}
