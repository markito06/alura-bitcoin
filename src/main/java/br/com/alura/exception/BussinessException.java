package br.com.alura.exception;

public class BussinessException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BussinessException(final String msg) {
		super(msg);
	}
}
