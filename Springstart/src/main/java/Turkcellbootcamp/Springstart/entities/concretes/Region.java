package Turkcellbootcamp.Springstart.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "region")
public class Region {

    @Id
    @Column(name = "region_id")
    private short regionId;

    @Column(name = "region_description")
    private String regionDescription;

    @OneToMany(mappedBy ="region")
    private List<Territory> territories;




}
