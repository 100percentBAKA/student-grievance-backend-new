package com.rnsit.studentgrievance.service;

import com.rnsit.studentgrievance.entity.Category;
import com.rnsit.studentgrievance.repository.CategoryRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
      @Autowired private CategoryRepository categoryRepository;

      @Transactional
      public void save(Category category) {
            categoryRepository.save(category);
      }

      public List<Category> getCategories() {
            return categoryRepository.findAll();
      }

      public Category getCategory(String category_name) {
            return categoryRepository.findById(category_name).orElse(null);
      }
}
