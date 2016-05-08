package ar.com.api.mk.impl;

import ar.com.api.mk.MikrotikApiException;

/**
 * Thrown when the Mikrotik returns an error when receiving our command.
 * @author GideonLeGrange
 */
@SuppressWarnings("serial")
public class ApiCommandException extends MikrotikApiException {


    /** return the tag associated with this exception, if there is one
     * @return the tag associated with this exception. Null if there is no tag*/
    public String getTag() {
        return tag;
    }

     ApiCommandException(String msg) {
        super(msg);
    }

     ApiCommandException(String msg, Throwable err) {
        super(msg, err);
    }


    ApiCommandException(Error err) {
        super(err.getMessage());
        tag = err.getTag();
    }
    
    private String tag = null;
    
}
