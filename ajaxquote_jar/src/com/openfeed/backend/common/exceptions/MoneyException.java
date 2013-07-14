package com.openfeed.backend.common.exceptions;

/**
 * Money Exception 
 * 
 * @version 	1.0
 * @author		couellette
 * 
 *  <p><b>Modification History</b><br>
 *  Date: Oct 6, 2005<br>
 *  Author: C. Ouellette<br>
 *  Comments: Original<br>
 */
public class MoneyException extends WrappedException {

	public MoneyException(String strMessage) {
		super(strMessage);
	}

	public MoneyException(Throwable t) {
		super(t);
	}

	public MoneyException(Throwable t, String strMessage) {
		super(t, strMessage);
	}
}
