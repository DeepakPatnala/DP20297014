package com.example.model;

import java.util.List;
import java.util.OptionalInt;
import java.util.Set;

public class Response {
	
	private OptionalInt highestNumber;
	private Set<String> duplicates;
	private List<String> removeSpaces;
	
	public Response() {
		super();
	}

	public Response(OptionalInt highestNumber, Set<String> duplicates, List<String> removeSpaces) {
		super();
		this.highestNumber = highestNumber;
		this.duplicates = duplicates;
		this.removeSpaces = removeSpaces;
	}

	public OptionalInt getHighestNumber() {
		return highestNumber;
	}

	public void setHighestNumber(OptionalInt optionalInt) {
		this.highestNumber = optionalInt;
	}

	public Set<String> getDuplicates() {
		return duplicates;
	}

	public void setDuplicates(Set<String> duplicates) {
		this.duplicates = duplicates;
	}

	public List<String> getRemoveSpaces() {
		return removeSpaces;
	}

	public void setRemoveSpaces(List<String> removeSpaces) {
		this.removeSpaces = removeSpaces;
	}
	
	
	
}
