package com.openfeed.backend.common.exceptions.runtime;

/**
 * 
 * @author Master
 *
 */
public class DataIntegrityException extends RuntimeException {
	
	private final Throwable m_cause;

	public DataIntegrityException(String strMessage) {
		super(strMessage);
		m_cause = null;
	}
	
	public DataIntegrityException(Throwable t, String strMessage)
		{
			super(strMessage);
			m_cause = t;
		}
}
