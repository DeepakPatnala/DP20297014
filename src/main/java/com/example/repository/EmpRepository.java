package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.model.Request;

@Repository
public interface EmpRepository extends JpaRepository<Request, Integer>{
	
	
	//To get largest column from the number column of the request table
	@Query(value="select max(number) from request", nativeQuery=true)
	int largestNumber();
	
	//To get the all the elements as a number column from request table
	@Query(value="select number from request", nativeQuery=true)
	int[] numberArray();	
	
	//To get the all the elements as a number column from request table
	@Query(value="select name from request", nativeQuery=true)
	String[] nameArray();	

}
