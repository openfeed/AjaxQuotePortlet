package com.openfeed.backend.common.exceptions;

/**
 * 
 * @author Master
 *
 */
public class DuplicateRecordException extends WrappedException {

	public DuplicateRecordException(String strMessage) {
		super(strMessage);
	}

	public DuplicateRecordException(Throwable t) {
		super(t);
	}

	public DuplicateRecordException(Throwable t, String strMessage) {
		super(t, strMessage);
	}

}
