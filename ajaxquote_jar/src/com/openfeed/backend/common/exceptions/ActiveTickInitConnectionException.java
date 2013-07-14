package com.openfeed.backend.common.exceptions;

public class ActiveTickInitConnectionException extends WrappedException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 776342468574194741L;

	public ActiveTickInitConnectionException(String strMessage) {
		super(strMessage);
	}

	public ActiveTickInitConnectionException(Throwable t) {
		super(t);
	}

	public ActiveTickInitConnectionException(Throwable t, String strMessage) {
		super(t, strMessage);
	}
}
