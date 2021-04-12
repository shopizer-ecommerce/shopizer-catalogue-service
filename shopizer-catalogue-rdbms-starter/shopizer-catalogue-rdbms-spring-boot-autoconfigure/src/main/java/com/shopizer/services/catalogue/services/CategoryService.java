package com.shopizer.services.catalogue.services;

import java.util.List;
import javax.transaction.Transactional;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shopizer.services.catalogue.model.category.Category;
import com.shopizer.services.catalogue.repository.category.CategoryRepository;

@Service
@Transactional
public class CategoryService {

  @Autowired
  private CategoryRepository categoryRepository;

  public void save(Category category) {
    Validate.notNull(category, "Category cannot be null");
    categoryRepository.save(category);
  }
  
  public List<Category> findAll() {
    return categoryRepository.findAll();
  }
  
  public Category getByCode(String code, String merchant) {
    return null;
    
  }

}
