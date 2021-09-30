package com.newvision.com.Assignment1.javaView;



import com.newvision.com.Assignment1.persistence.entity.JsonValidator;

public class JsonValidatorViewDTO {
	private JsonValidator jsonValidator;

	
	public void setJsonValidator(JsonValidator jsonValidatorNew) {
		this.jsonValidator = jsonValidatorNew;
	}
	  public void print() {
	        
	         System.out.println("================================");
	       
	         System.out.println("--------------------------------");
	         System.out.println("JsonValidatorViewDTO   = " + jsonValidator);
	         System.out.println("");
	     }

	

}
