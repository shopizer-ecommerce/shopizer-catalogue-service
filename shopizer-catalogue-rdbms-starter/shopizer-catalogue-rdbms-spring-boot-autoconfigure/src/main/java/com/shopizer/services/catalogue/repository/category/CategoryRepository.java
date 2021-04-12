package com.shopizer.services.catalogue.repository.category;

import org.springframework.data.jpa.repository.JpaRepository;
import com.shopizer.services.catalogue.model.category.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
  
  //@Query("")
  //Category findByCode(String code, String merchant)

}

