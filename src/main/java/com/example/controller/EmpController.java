package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Request;
import com.example.model.Response;
import com.example.serviceImpl.EmpServiceImpl;

@RestController
public class EmpController {
	
	@Autowired
	private EmpServiceImpl service;
	
	@PostMapping("/add")
	public ResponseEntity<Request> addAccount(@RequestBody Request a) {
		Request acc=service.add(a);
		return ResponseEntity.status(HttpStatus.CREATED).body(acc);
	}
	
	@GetMapping("/highest")
	public Response response() {
		Response response=new Response();
		response.setHighestNumber(service.numbersMeetNumbers());
		response.setDuplicates(service.findDuplicates());
		response.setRemoveSpaces(service.whiteSpacesGalore());
		return response;
	}
	
}
