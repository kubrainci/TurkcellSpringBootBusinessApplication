package Turkcellbootcamp.Springstart.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "employees")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Employee {
    @Id
    @Column(name = "employee_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short employeesId;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "title")
    private String title;

    @Column(name = "title_of_courtesy")
    private String titleOfCourtesy;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "hire_date")
    private LocalDate hireDate;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "region")
    private String region;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "country")
    private String country;

    @Column(name = "extension")
    private String extension;

    @Column(name = "home_phone")
    private String homePhone;

    @Column(name = "photo")
    private byte [] photo;

    //çokluk durumu yani bir employeenin(çalışanın) birden fazla order(şiparişi ) olabilir.
    @OneToMany(mappedBy = "employee")
    private List<Order>orders;

    @OneToMany(mappedBy = "employee")
    private List<EmployeeTerritory>employeeTerritories;


}
