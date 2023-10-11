package Turkcellbootcamp.Springstart.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "us_states")

public class UsStates {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "state_id")
    private short stateId;

    @Column(name = "state_name")
    private String stateName;

    @Column(name = "state_abbr")
    private  String stateAbbr;

    @Column(name ="state_region" )
    private String stateRegion;
}
