/**
 * 
 */
package com.openfeed.backend.common.exceptions;

/**
 * Legacy Exception
 * 
 * @version 	1.0
 * @author		dicicca
 * 
 *  <p><b>Modification History</b><br>
 *  Date: Aug 25, 2010<br>
 *  Author: A. DiCicco<br>
 *  Comments: Original<br>
 */
public class LegacyException  extends WrappedException {

	public LegacyException(String strMessage) {
		super(strMessage);
	}

	public LegacyException(Throwable t) {
		super(t);
	}

	public LegacyException(Throwable t, String strMessage) {
		super(t, strMessage);
	}

}