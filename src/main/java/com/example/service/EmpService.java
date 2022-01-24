package com.example.service;

import java.util.List;
import java.util.OptionalInt;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.example.model.Request;

@Service
public interface EmpService {

	public Request add(Request a);

	public OptionalInt numbersMeetNumbers();

	public Set<String> findDuplicates();

	public List<String> whiteSpacesGalore();
}
