package com.newvision.com.Assignment1.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newvision.com.Assignment1.persistence.entity.JsonValidator;
import com.newvision.com.Assignment1.repository.JsonRepository;
@Service
public class JsonService {
	@Autowired
	private JsonRepository jsonRepo;
	
	public JsonValidator addJson(JsonValidator jsonVal) {
		return jsonRepo.save(jsonVal);
	}
	
	


}
