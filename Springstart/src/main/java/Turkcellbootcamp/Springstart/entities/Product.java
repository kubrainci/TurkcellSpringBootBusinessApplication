package Turkcellbootcamp.Springstart.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Product {
    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "supplier_id")
    private short supplierId;

    @Column(name = "category_id")
    private int categoryId;

    @Column(name = "quantity_per_unit")
    private String quantityPerUnit;

    @Column(name = "unit_price")
    private  float unitPrice;

    @Column(name = "units_in_stock")
    private short unitsInStock;

    @Column(name = "units_on_order")
    private short unitsOnOrder;

    @Column(name = "reorder_level")
    private short reorderLevel;

    @Column(name = "discontinued")
    private int discontinued;

    //Bağlantı noktası
    @OneToMany(mappedBy = "product")
    private List<OrderDetail>orderDetails;


}
