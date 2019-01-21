package com.valuequo.buckswise.repository;

import java.util.List;
import com.valuequo.buckswise.domain.Amfi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AmfiRepository extends JpaRepository<Amfi, String> {
	@Query("select a from Amfi a where a.amc_code = :name")
	List<Amfi> findByAmc_code(@Param("name") String name );
	
	
	// List<Amfi> findSchemename();

	// @Query("SELECT t.schemename FROM Amfi t")
	// List<Amfi> getSchemename();

	// public static final String query = "SELECT a schemename FROM Amfi a";

	// @Query(value = query, nativeQuery = true)
	// List<Amfi> findAmfi();

	// List<Amfi> findschemename();

}