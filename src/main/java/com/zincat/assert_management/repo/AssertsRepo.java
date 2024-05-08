package com.zincat.assert_management.repo;

import com.zincat.assert_management.entity.Asserts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AssertsRepo extends JpaRepository<Asserts, Integer> {
    @Query(value = "SELECT * from Asserts", nativeQuery = true )
    List<Asserts> getAsserts();

    Asserts findAssertsById(int id);
}
