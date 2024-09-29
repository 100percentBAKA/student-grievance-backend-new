package com.rnsit.studentgrievance.repository;

import com.rnsit.studentgrievance.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, String> {
}
