package com.rnsit.studentgrievance.controller;

import com.rnsit.studentgrievance.entity.Category;
import com.rnsit.studentgrievance.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
      @Autowired private CategoryService categoryService;

      @PostMapping
      public ResponseEntity<String> addCategory(@RequestBody Category category) {
            categoryService.save(category);
            return new ResponseEntity<>(HttpStatus.OK);
      }

      @GetMapping("/get-all")
      public ResponseEntity<List<Category>> getCategories() {
            return new ResponseEntity<>(categoryService.getCategories(), HttpStatus.OK);
      }

      @GetMapping("/{category}")
      public ResponseEntity<Category> getCategory(@PathVariable String category) {
            return new ResponseEntity<>(categoryService.getCategory(category), HttpStatus.OK);
      }
}
