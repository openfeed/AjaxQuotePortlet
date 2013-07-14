package com.openfeed.backend.common.exceptions;

import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * 
 * @author Master
 *
 */
public abstract class WrappedException extends Exception {

	/**
	 * Creates a <code>WrappedException</code> that is not based on a 
	 * lower-level exception.
	 * 
	 * @param strMessage a {@link String} that is used as a description for this
	 * exception.
	 */
    protected WrappedException(String strMessage)
    {
        super(strMessage);
        m_cause = null;
    }

	/**
	 * Creates a <code>WrappedException</code> that is based on a 
	 * lower-level exception.
	 * 
	 * @param t the {@link Throwable} that is added to the "chain" of 
	 * exceptions.
	 */
    protected WrappedException(Throwable t)
    {
        m_cause = t;
    }

	/**
	 * Creates a <code>WrappedException</code> that is based on a 
	 * lower-level exception.
	 * 
	 * @param t the {@link Throwable} that is added to the "chain" of 
	 * exceptions.
	 * @param strMessage a {@link String} that is used as a description for this
	 * exception.
	 */
    protected WrappedException(Throwable t, String strMessage)
    {
        super(strMessage);
        m_cause = t;
    }

	/**
	 * Returns the {@link Throwable} that this exception is based on, 
	 * or <code>null</code> if this exception is not based on a lower-level
	 * exception.
	 */
    final public Throwable getCause()
    {
        return m_cause;
    }

	/**
	 * Prints the stack trace for this exception to standard out.  This stack 
	 * trace will contain all of the stack traces in the "chain" of exceptions.
	 */
    public void printStackTrace() 
    {
        super.printStackTrace();
        if (m_cause != null) 
        {
            System.err.println("Caused by:");
            m_cause.printStackTrace();
        }
    }

	/**
	 * Prints the stack trace for this exception to the specified 
	 * {@link PrintStream}.  This stack trace will contain all of the stack 
	 * traces in the "chain" of exceptions.  
	 *
	 * @param PrintStream that the stack trace will be printed to.
	 */
    public void printStackTrace(PrintStream ps)
    {
        super.printStackTrace(ps);
        if (m_cause != null) 
        {
            ps.println("Caused by:");
            m_cause.printStackTrace(ps);
        }
    }

	/**
	 * Prints the stack trace for this exception to the specified 
	 * {@link PrintStream}.  This stack trace will contain all of the stack 
	 * traces in the "chain" of exceptions.  
	 *
	 * @param PrintWriter that the stack trace will be printed to.
	 */
    public void printStackTrace(PrintWriter pw)
    {
        super.printStackTrace(pw);
        if (m_cause != null) 
        {
            pw.println("Caused by:");
            m_cause.printStackTrace(pw);
        }
    }
 
    private final Throwable m_cause;

}
