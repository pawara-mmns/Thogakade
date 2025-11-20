package model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {

    private String customerId;

    private String title;

    private String name;

    private LocalDate dateOfBirth;

    private Double salary;

    private String address;

    private String city;

    private String province;

    private String postalCode;
}
