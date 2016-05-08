package ar.com.api.mk;

/**
 * Exception thrown if the Api experiences a connection problem
 * @author GideonLeGrange
 */
@SuppressWarnings("serial")
public class ApiConnectionException extends MikrotikApiException {

    public ApiConnectionException(String msg) {
        super(msg);
    }

    public ApiConnectionException(String msg, Throwable err) {
        super(msg, err);
    }
    
    
    
}
