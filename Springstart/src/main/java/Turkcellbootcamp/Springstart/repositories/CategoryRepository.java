package Turkcellbootcamp.Springstart.repositories;



import Turkcellbootcamp.Springstart.entities.concretes.Category;
import Turkcellbootcamp.Springstart.entities.dtos.CategoryDtos.CategoryForListingDto;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Integer> {

    //  DERİVED QUERY METHODS

    //categoryName 'nin tamamını iste
    Category findByCategoryName(String categoryName);

    //categoryName 'nin bir kaç harfini iste
    List<Category> findByCategoryNameContaining(String categoryName);



    //JPQL
    // -->categoryName 'nin bir kaç harfini iste
    @Query(value = "SELECT c FROM Category c WHERE c.categoryName LIKE %:name%",nativeQuery = false)
    List<Category>search(@Param("name") String categoryName);

    //CategoryName a dan z ye doğru sırala
    @Query(value = "Select c from Category c  Order By c.categoryName ASC",nativeQuery = false)
    List<Category>findByOrderByCategoryNameAsc(String categoryName);

    //Native SQL
    // --->categoryName 'nin tamamını iste

    @Query(value = "SELECT * FROM Categories c WHERE c.category_name =:categoryName%", nativeQuery = true)
    List<Category> searchNative(String categoryName);
    @Query(value = "SELECT COUNT(*) FROM categories", nativeQuery = true)
    Integer countCategories();

    /*"Select new " +
            "com.turkcell.workshop.entities.dtos.CategoryForListingDto(c.categoryId,c.categoryName) From Category c")
    List<CategoryForListingDto> getForListing();
*/

    //DTO'YU KULLANMAK İÇİN JPQL OLUŞTURUYORUZ
     @Query(value = "Select new"+
             " Turkcellbootcamp.Springstart.entities.dtos.CategoryDtos.CategoryForListingDto(c.categoryId,c.categoryName)From Category c")
     List<CategoryForListingDto>getForListing();




}





