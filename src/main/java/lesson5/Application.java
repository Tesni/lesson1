package lesson5;

import java.math.BigDecimal;
import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Ваня", "Директор", "vanya@org.ru", "322223322",
                new BigDecimal(750000), 41);
        employees[1] = new Employee("Маша", "Дизайнер", "masha@org.ru", "12345678",
                new BigDecimal(150000), 19);
        employees[2] = new Employee("Сергей", "Инженер", "sergey@org.ru", "87654321",
                new BigDecimal(100000), 32);
        employees[3] = new Employee("Сан Саныч", "Руководитель проектов", "sanych@org.ru",
                "111222333", new BigDecimal(350000), 53);
        employees[4] = new Employee("Баба Клава", "Уборщица", "нету", "56565656",
                new BigDecimal(10000), 61);

        for (Employee employee : employees) {
            if (employee.getAge() > 40) {
                System.out.println(employee.toString());
            }
        }
    }
}
