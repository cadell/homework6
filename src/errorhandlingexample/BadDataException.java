package errorhandlingexample;

/**
 *
 * The error handling class extends from the runtimeException class. 
 */
public class BadDataException extends RuntimeException {
    
    /**
     * the Constructor executes the constructor of the RuntimeException class
     */
    public BadDataException()
    {
        super();
    }
    
    /**
     * The overloaded Constructor calls the overloaded Constructor of the superclass
     * @param message 
     */
    public BadDataException(String message)
    {
        super(message);
    }
    
}
