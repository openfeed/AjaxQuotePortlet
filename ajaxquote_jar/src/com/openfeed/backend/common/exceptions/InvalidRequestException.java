package com.openfeed.backend.common.exceptions;

/**
 * 
 * @author Master
 *
 */
public class InvalidRequestException extends WrappedException {

	public InvalidRequestException(String strMessage) {
		super(strMessage);
	}

	public InvalidRequestException(Throwable t) {
		super(t);
	}

	public InvalidRequestException(Throwable t, String strMessage) {
		super(t, strMessage);
	}

}
