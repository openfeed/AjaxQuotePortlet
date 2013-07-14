package com.openfeed.backend.common.exceptions;




/**
 * 
 * @author Master
 *
 */
public class ConfigException extends WrappedException {
	public ConfigException(String strMessage) {
		super(strMessage);
	}

	public ConfigException(Throwable t) {
		super(t);
	}

	public ConfigException(Throwable t, String strMessage) {
		super(t, strMessage);
	}
}
