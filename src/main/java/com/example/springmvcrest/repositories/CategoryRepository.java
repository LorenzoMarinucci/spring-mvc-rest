package com.example.springmvcrest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.springmvcrest.domain.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
