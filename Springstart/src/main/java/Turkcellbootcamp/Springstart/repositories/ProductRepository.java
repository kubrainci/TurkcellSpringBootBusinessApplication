package Turkcellbootcamp.Springstart.repositories;

import Turkcellbootcamp.Springstart.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Short> {

    //DERİVED QUERY METHODS

   //productName'yi benzer harflerden olusan ürünleri getir
    List<Product> findByProductNameContaining(String productName);

    //UnitPrice'nden  daha küçük olanları listele
    List<Product>findByUnitPriceLessThan(float unitPrice);

    //UnitsInStock'dan daha büyük olanları listele
    List<Product>findByUnitsInStockGreaterThan(short unitsInStock);

    //JPQL

    //ProductName leri a dan z ye doğru sırala
    @Query(value = "Select p from Product p Order By p.productName ASC ",nativeQuery = false)
    List<Product>findByProductOrderByProductNameAsc(String productName);

    //Verilen değer kadar şiparişi olan ürünleri getir
    @Query(value = "Select p from Product p Where p.unitsOnOrder = unitsOnOrder",nativeQuery = false)
    List<Product> findProductsByUnitsOnOrder(short unitsOnOrder);

    //UnitsOnOrder =0 olan ürünleri getir
    @Query(value = "Select p from Product p Where p.unitsOnOrder = 0",nativeQuery = false)
   List<Product> findProductsByUnitsOnOrderZero(short unitsOnOrder);


    //NATİVE SQL

    //ProductName'ye göre getir
    @Query(value = "SELECT * FROM products  WHERE  product_name =:productName%",nativeQuery = true)
    List<Product>searchProductName(String productName);

    //UnitsInStock = 0 olan ürünleri listele
    @Query(value = "Select *from products Where units_in_stock=0",nativeQuery = true)
    List<Product>findProductsByUnitsInStockTrueNativeSql(short unitsInStock);


}
