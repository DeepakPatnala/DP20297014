package com.example.serviceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.OptionalInt;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Request;
import com.example.repository.EmpRepository;
import com.example.service.EmpService;

@Service
public class EmpServiceImpl implements EmpService{
	
	@Autowired
	private EmpRepository repository;

	
	@Override
	public Request add(Request a) {
		Request add= repository.save(a);
		return add;
	}
	
	//To find highest number
	@Override
	public OptionalInt numbersMeetNumbers(){
		int[] arr=repository.numberArray();
		return Arrays.stream(arr).max();		
	}
	
	//To find duplicates
	@Override
	public Set<String> findDuplicates() {
		Set<String> set=new HashSet<>();
		String[] strarr=repository.nameArray();
		for(int i=0; i<strarr.length; i++) {
			for(int j=i+1; j<strarr.length; j++) {
				if(strarr[i]==strarr[j]) {
					set.add(strarr[j]);
				}
			}
		}
		return set;
	}
	
	//To remove whitespace
	@Override
	public List<String> whiteSpacesGalore() {
		List<String> stringsWithoutSpaces = new ArrayList<>(); 
		String[] strarr=repository.nameArray();
		String stringWithoutSpaces = "";
		for(int i=0;i<strarr.length;i++) {
			for(int j=0; j<strarr[i].length(); j++) {
				if(strarr[i].charAt(j)!=' ')
					stringWithoutSpaces=stringWithoutSpaces+strarr[i].charAt(j);
			else
				 continue;
			}
			stringsWithoutSpaces.add(stringWithoutSpaces);
			stringWithoutSpaces = "";
		}
		return stringsWithoutSpaces;
	}

}
