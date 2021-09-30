package com.newvision.com.Assignment1.controller;

import org.dozer.DozerBeanMapper;

import com.newvision.com.Assignment1.javaView.JsonValidatorView;
import com.newvision.com.Assignment1.javaView.JsonValidatorViewDTO;



public class MainController {

	public static void main(String[] args) {
		JsonValidatorView s = new JsonValidatorView();
	       s.print();

	        System.out.println("Now dozing...");
	        System.out.println("");

	        JsonValidatorViewDTO t = new DozerBeanMapper().map(s, JsonValidatorViewDTO.class);
	        t.print();
	      


	}

}
