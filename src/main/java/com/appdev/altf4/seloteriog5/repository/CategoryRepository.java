package com.appdev.altf4.seloteriog5.repository;

import com.appdev.altf4.seloteriog5.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
