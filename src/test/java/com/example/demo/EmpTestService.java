package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.model.Request;
import com.example.repository.EmpRepository;
import com.example.serviceImpl.EmpServiceImpl;

@ExtendWith(MockitoExtension.class)
class EmpTestService {
	
	@InjectMocks
	private EmpServiceImpl service;
	
	@Mock
	private EmpRepository repository;

	private Request customer1;

	@BeforeEach
	public void setUp() throws Exception {
		customer1 =new Request("Deepak Patnala",true,200);
	}

	@AfterEach
	void tearDown() throws Exception {
		customer1=null;
	}
	
	@Test
	void testAdd() {
		when(repository.save(Mockito.any(Request.class))).thenReturn(customer1);
		Request request=service.add(customer1);
		assertEquals(200, request.getNumber());
	}

	@Test
	void testNumbersMeetNumbers() {
		int[] arr= {1,3,50,100,5,0};
		when(repository.numberArray()).thenReturn(arr);
		OptionalInt res=service.numbersMeetNumbers();
		assertEquals(100, res.getAsInt());
	}

	@Test
	void testFindDuplicates() {
		String[] str= {"Deepak","Deepak","Customer","Customer"};
		when(repository.nameArray()).thenReturn(str);
		Set<String> res=service.findDuplicates();
		assertEquals("[Customer, Deepak]", res.toString());		
	}

	@Test
	void testWhiteSpacesGalore() {
		String[] str= {"Deepak Patnala","abc def"};
		when(repository.nameArray()).thenReturn(str);
		List<String> res =service .whiteSpacesGalore();
		assertEquals("[DeepakPatnala, abcdef]", res.toString());
	}

}
