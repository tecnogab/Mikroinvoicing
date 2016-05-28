package ar.com.api.mk;

/**
 * Thrown by the Mikrotik API to indicate errors
 *
 * @author GideonLeGrange
 * 
 * 
 */
@SuppressWarnings("serial")
public class MikrotikApiException extends Exception {

    public MikrotikApiException(String msg) {
        super(msg);
    }

    public MikrotikApiException(String msg, Throwable err) {
        super(msg, err);
    }
}
