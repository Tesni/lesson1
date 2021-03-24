package lesson10.phonebook;

import java.util.Objects;

public class PhoneBookEntry {
    private final String surname;
    private final String phoneNumber;

    public PhoneBookEntry(String surname, String phoneNumber) {
        this.surname = surname;
        this.phoneNumber = phoneNumber;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneBookEntry that = (PhoneBookEntry) o;
        return Objects.equals(surname, that.surname) &&
                Objects.equals(phoneNumber, that.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surname, phoneNumber);
    }
}
