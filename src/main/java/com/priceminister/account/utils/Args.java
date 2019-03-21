package com.priceminister.account.utils;

public class Args {
    
    // ------------------------------------------------------------------------
    // Constructors
    // ------------------------------------------------------------------------
    
    /**
     * Default constructor, private on purpose.
     * 
     * @throws UnsupportedOperationException always.
     */
    private Args() {
        throw new UnsupportedOperationException();
    }
    
    // ------------------------------------------------------------------------
    // Args contract definition
    // ------------------------------------------------------------------------
    
    /**
     * Check that a given argument is not null.
     * 
     * @param o the argument to check.
     * @param msg the error message.
     * @return the argument.
     * @if <code>o</code> is not <code>null</code>.
     */
    public static <T> T notNull(T o, String msg) {
        if (o == null) {
            throw new IllegalArgumentException(msg);
        }
        return o;
    }
    
    // ------------------------------------------------------------------------
    // Args contract definition
    // ------------------------------------------------------------------------
    
    /**
     * Check that a given argument is null.
     * 
     * @param o the argument to check.
     * @param msg the error message.
     * @return the argument.
     * @if <code>o</code> is <code>null</code>.
     */
    public static <T> T isNull(T o, String msg) {
        if (o != null) {
            throw new IllegalArgumentException(msg);
        }
        return o;
    }
    
    /**
     * Check that a given numeric argument is positive, i.e. greater than zero.
     * 
     * @param l the argument to check.
     * @param msg the error message.
     * @return the argument.
     * @if <code>l</code> is negative or equal to zero.
     */
    public static Double positive(Double l, String msg) {
        if (l == null || l <= 0) {
            throw new IllegalArgumentException(msg);
        }
        return l;
    }
    
}
