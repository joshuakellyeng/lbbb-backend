package com.lb.backend.repositories;





import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lb.backend.models.MenuItem;


@Repository
public interface MenuItemsRepository extends JpaRepository<MenuItem, Integer> {


}
