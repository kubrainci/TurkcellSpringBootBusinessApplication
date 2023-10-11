package Turkcellbootcamp.Springstart.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "territories")
public class Territory {

    @Id
    @Column(name = "territory_id")
    private String territoryId;

    @OneToMany(mappedBy = "territory")
    private List<EmployeeTerritory>employeeTerritories;

    @Column(name = "territory_description")
    private String territoryDescription;

    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;


}
