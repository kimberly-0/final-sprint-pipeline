package com.qa.cardatabase.data.repository;

import java.util.List;

import com.qa.cardatabase.data.entity.Car;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Long>{

	// Fetch cars by brand
	List<Car> findByBrand(String brand);

	// Fetch cars by colour
	List<Car> findByColour(String colour);
	
	// Fetch cars by year
	List<Car> findByYear(int year);
	
	// Fetch cars by brand and model
	List<Car> findByBrandAndModel(String brand, String model);
	
	// Fetch cars by brand or colour
	List<Car> findByBrandOrColour(String brand, String colour);
	
	// Fetch cars by brand and sort by year
	List<Car> findByBrandOrderByYearAsc(String brand);
	
    // Fetch cars by brand using SQL
    @Query("select c from Car c where c.brand like ?1%")
    List<Car> findByBrandStartsWith(String brand);

}
