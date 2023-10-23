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
@Table(name = "customer_demographics")
public class CustomerDemographic {
    @Id
    @Column(name ="customer_type_id")
    private String customerTypeId;

    @Column(name = "customer_desc")
    private String customerDesc ;

    @OneToMany(mappedBy ="customerDemographic")
    private List<CustomerCustomerDemo> customerCustomerDemos;

}
