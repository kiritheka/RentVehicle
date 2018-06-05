package com.rentals.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.rentals.model.Returning;

@Repository
public interface ReturningRepository extends JpaRepository<Returning,Integer> {

}
