package com.newvision.com.Assignment1.exception;

public class UserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UserNotFoundException(Long id) {
        super("User id not found : " + id);
    }


}
