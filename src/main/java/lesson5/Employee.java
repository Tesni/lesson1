package lesson5;

import java.math.BigDecimal;

public class Employee {
    private String fullName;
    private String position;
    private String email;
    private String phone;
    private BigDecimal salary;
    private int age;

    public Employee(String fullName, String position, String email, String phone, BigDecimal salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Сотрудник " + fullName +
                ", должность - " + position +
                ", email-адрес - " + email +
                ", телефон - " + phone +
                ", зарплата - " + salary +
                ", возраст - " + age;
    }
}
