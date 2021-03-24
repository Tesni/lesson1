package lesson10.phonebook;

import java.util.HashSet;
import java.util.Set;

public class PhoneBook {
    Set<PhoneBookEntry> phoneBookContent = new HashSet<>();

    public void add(String surname, String phoneNumber) {
        this.phoneBookContent.add(new PhoneBookEntry(surname, phoneNumber));
    }

    public void get(String surname) {
        StringBuilder sb = new StringBuilder();
        for (PhoneBookEntry entry : phoneBookContent) {
            if (entry.getSurname().equals(surname)) {
                sb.append(entry.getSurname()).append(" ").append(entry.getPhoneNumber()).append(System.lineSeparator());
            }
        }
        if (sb.length() == 0) {
            sb.append("По запросу ничего не найдено");
        }
        System.out.println(sb.toString());
    }
}
