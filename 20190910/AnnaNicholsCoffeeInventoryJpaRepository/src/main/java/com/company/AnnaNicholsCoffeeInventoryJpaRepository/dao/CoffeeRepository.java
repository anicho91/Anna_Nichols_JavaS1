package com.company.AnnaNicholsCoffeeInventoryJpaRepository.dao;

import com.company.AnnaNicholsCoffeeInventoryJpaRepository.dto.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoffeeRepository extends JpaRepository<Coffee, Integer> {
    List<Coffee> findById(Integer id);

    List<Coffee> findByType(String type);

    List<Coffee> findByRoasterId(Integer roasterId);

    List<Coffee> findByRoasterIdAndType(Integer roasterId, String type);
}
