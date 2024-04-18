package br.com.zenet.zenet.exception;

public class LoginException extends Exception {
	
	private static final long serialVersionUID = 1L;
	private String message;
	
	public LoginException(String message) {
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return this.message;
	}
}
