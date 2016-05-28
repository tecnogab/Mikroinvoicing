package ar.com.api.mk.impl;

import ar.com.api.mk.MikrotikApiException;

/**
 * Thrown if there is a problem unpacking data from the Api. 
 * @author GideonLeGrange
 * 
 * 
 */
@SuppressWarnings("serial")
public class ApiDataException extends MikrotikApiException {

    ApiDataException(String msg) {
        super(msg);
    }

    ApiDataException(String msg, Throwable err) {
        super(msg, err);
    }

    
    
}
