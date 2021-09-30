package com.newvision.com.Assignment1.controller;


import org.apache.commons.text.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.tags.HtmlEscapeTag;
import org.springframework.web.util.HtmlUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.newvision.com.Assignment1.javaView.JsonValidatorView;
import com.newvision.com.Assignment1.persistence.entity.JsonValidator;
import com.newvision.com.Assignment1.service.JsonService;
import com.newvision.com.Assignment1.utils.AntiXSSConfig;
import com.newvision.com.Assignment1.utils.JsonUtility;
import com.newvision.com.Assignment1.utils.AntiXSSConfig.HTMLCharacterEscapes;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("api/json")
@Api(value = "JsonController")
public class JsonController {
	@Autowired
	private JsonService jsonService;
	
	@RequestMapping(value = "/checkJson", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Insert new json ")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Json validated successfully") })
	public ResponseEntity<JsonValidatorView> addjson( @RequestBody JsonValidatorView jsonval) {
		ObjectMapper mapper = new ObjectMapper() ;
	//	AntiXSSConfig.configeJackson(mapper);
		//String output="";
		try {
			Gson gson = new Gson();
		    String jsonString = gson.toJson(jsonval);
  	 System.out.println("jsonString====="+jsonString);
			 jsonval = gson.fromJson(jsonString, JsonValidatorView.class);
					System.out.println("jsonval request view===="+jsonval.getClass()+"=="+jsonval.getContactDetailsView());
			
			} catch (Exception e) {
			// TODO Auto-generated catch block 
			e.printStackTrace(); 
			}
		

		
		
		return new ResponseEntity<JsonValidatorView>(jsonval, HttpStatus.CREATED);
	}
	
	
}
