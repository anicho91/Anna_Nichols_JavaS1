package com.company.AnnaNicholsCoffeeInventoryJpaRepository.dao;

import com.company.AnnaNicholsCoffeeInventoryJpaRepository.dto.Roaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoasterRepository extends JpaRepository<Roaster, Integer> {
    List<Roaster> findById(Integer id);
}
