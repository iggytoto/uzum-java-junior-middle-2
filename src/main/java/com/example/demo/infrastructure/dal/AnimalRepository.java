package com.example.demo.infrastructure.dal;

import com.example.demo.domain.Animal;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@NamedQuery(name = "getAnimalsByName", query = "from Animal a where a.name = ?")
@NamedNativeQuery(name = "getAimalsByName", query = "SELECT * FROM animal a WHERE a.name like '%?'")
public interface AnimalRepository extends JpaRepository<Animal,Integer> {

    List<Animal> getAnimalsByName(String name);

}
