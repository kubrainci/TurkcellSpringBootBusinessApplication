package Turkcellbootcamp.Springstart.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employee_territories ")
public class EmployeeTerritory {

    @Id
    @ManyToOne
    @JoinColumn(name ="employee_id")
    private Employee employee;


    @ManyToOne
    @JoinColumn(name = "territory_id")
    private Territory territory;
}
