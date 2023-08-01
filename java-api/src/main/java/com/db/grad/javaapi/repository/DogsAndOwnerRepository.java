package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.Dog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DogsAndOwnerRepository extends JpaRepository<Dog, Long> {

    @Query(nativeQuery = true, value = "select dog_owner from dog_n_owners where dog = :name")
    List<String> findByName(String name);

}