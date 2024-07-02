package com.example.demo.infrastructure;

import com.example.demo.domain.Cage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CageRepository extends JpaRepository<Cage,Integer> {
}
