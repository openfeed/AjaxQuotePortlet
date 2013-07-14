package com.openfeed.backend.common.exceptions;

/**
 * 
 * @author Master
 *
 */
public class ProcessingException extends WrappedException {

	public ProcessingException(String strMessage) {
		super(strMessage);
	}

	public ProcessingException(Throwable t) {
		super(t);
	}

	public ProcessingException(Throwable t, String strMessage) {
		super(t, strMessage);
	}

}
