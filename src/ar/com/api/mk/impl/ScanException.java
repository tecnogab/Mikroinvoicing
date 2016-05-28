package ar.com.api.mk.impl;

/**
 * Exception thrown if the scanner encounters an error while scanning a command line.
 * @author GideonLeGrange
 * 
 * 
 */
@SuppressWarnings("serial")
public class ScanException extends ParseException {

    ScanException(String msg) {
        super(msg);
    }

    ScanException(String msg, Throwable err) {
        super(msg, err);
    }
    
}
