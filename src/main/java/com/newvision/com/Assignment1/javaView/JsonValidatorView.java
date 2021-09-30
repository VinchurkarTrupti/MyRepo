package com.newvision.com.Assignment1.javaView;

import java.util.List;

import com.newvision.com.Assignment1.persistence.ContactDetailsView;
import com.newvision.com.Assignment1.persistence.entity.JsonValidator;

public class JsonValidatorView {
	private List<ContactDetailsView> contactDetailsView;
	 private JsonValidator JsonValidator;
	public JsonValidator getJsonValidator() {
		return JsonValidator;
	}

/*	public void setJsonValidator(JsonValidator jsonValidator) {
		this.jsonValidator = jsonValidator;
	}
*/
	public List<ContactDetailsView> getContactDetailsView() {
		return contactDetailsView;
	}

	/*public void setContactDetailsView(List<ContactDetailsView> contactDetailsView) {
		this.contactDetailsView = contactDetailsView;
	}*/

//	private JsonValidator jsonValidator;

	

	 public JsonValidatorView() {
		 
		 JsonValidator = getJsonValidator();
				 
	 }
	 
	 public void print() {
	        
         System.out.println("================================");
       
         System.out.println("--------------------------------");
         System.out.println("JsonValidatorView   = " + JsonValidator);
         System.out.println("");
     }
	
}
