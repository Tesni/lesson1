package lesson10;

import lesson10.phonebook.PhoneBook;

import java.util.HashMap;
import java.util.Map;

public class Collections {
    public static void main(String[] args) {

        // Задание 1
        String skazka = "жили были дед да баба и была у них курочка ряба снесла курочка яичко да не простое а золотое" +
                " дед бил бил не разбил баба била била не разбила а мышка бежала хвостиком махнула яичко упало и разбилось";
        String[] words = skazka.split(" ");
        Map<String, Integer> calculationMap = new HashMap<>();
        for (String word : words) {
            calculationMap.compute(word, (k, v) -> (v == null) ? 1 : v+1);
        }

        for (Map.Entry<String, Integer> entry : calculationMap.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        // Задание 2
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Иванов", "223-322-223");
        phoneBook.add("Джобс", "777-77-777");
        phoneBook.add("Гейтс", "345-345-345");
        phoneBook.add("Иванов", "111-000-111");

        phoneBook.get("Джобс");
        phoneBook.get("Иванов");
        phoneBook.get("Нагнибедов");
    }
}
