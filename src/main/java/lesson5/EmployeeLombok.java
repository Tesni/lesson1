package lesson5;

import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeLombok {
    private String fullName;
    private String position;
    private String email;
    private String phone;
    private BigDecimal salary;
    private int age;

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
