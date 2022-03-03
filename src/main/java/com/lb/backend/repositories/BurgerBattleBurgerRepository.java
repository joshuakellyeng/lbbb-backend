package com.lb.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lb.backend.models.BurgerBattleBurger;

@Repository
public interface BurgerBattleBurgerRepository extends JpaRepository<BurgerBattleBurger, Integer> {

}
