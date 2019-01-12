package br.com.register.customer.exception;

public class RegisterCustomerException extends RuntimeException {

	private static final long serialVersionUID = 2434014617628789765L;
	
	private final String message;

	public RegisterCustomerException(final String message) {
		this.message = message;
	}

}