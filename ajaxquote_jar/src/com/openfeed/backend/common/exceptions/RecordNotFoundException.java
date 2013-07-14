package com.openfeed.backend.common.exceptions;

/**
 * 
 * @author Master
 *
 */
public class RecordNotFoundException extends WrappedException {

	public RecordNotFoundException(String strMessage) {
		super(strMessage);
	}

	public RecordNotFoundException(Throwable t) {
		super(t);
	}

	public RecordNotFoundException(Throwable t, String strMessage) {
		super(t, strMessage);
	}

}
