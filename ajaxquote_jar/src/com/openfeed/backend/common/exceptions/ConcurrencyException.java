package com.openfeed.backend.common.exceptions;
/**
 * 
 * @author Master
 *
 */
public class ConcurrencyException extends WrappedException {

	public ConcurrencyException(String strMessage) {
		super(strMessage);
	}

	public ConcurrencyException(Throwable t) {
		super(t);
	}

	public ConcurrencyException(Throwable t, String strMessage) {
		super(t, strMessage);
	}
}
