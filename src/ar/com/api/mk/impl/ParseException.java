package ar.com.api.mk.impl;

import ar.com.api.mk.MikrotikApiException;

/**
 * Exception thrown if the parser encounters an error while parsing a command line.
 * @author GideonLeGrange
 * 
 * 
 */
@SuppressWarnings("serial")
public class ParseException extends MikrotikApiException {

    ParseException(String msg) {
        super(msg);
    }

    ParseException(String msg, Throwable err) {
        super(msg, err);
    }
    
    
    
}
