package com.lb.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lb.backend.models.MenuItemCategory;

@Repository
public interface MenuItemCategoryRepository extends JpaRepository<MenuItemCategory, Integer> {

}
