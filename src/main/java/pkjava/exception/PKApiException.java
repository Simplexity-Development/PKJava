package pkjava.exception;

public class PKApiException extends Exception {

    private final int errorCode;
    private final int httpResponseCode;

    /**
     * Creates a new Exception representing an error with the PluralKit API.
     * @param message Descriptive Message
     * @param errorCode PluralKit Error Code
     * @param httpResponseCode HTTP Response Status Code
     */
    public PKApiException(String message, int errorCode, int httpResponseCode) {
        super(message);
        this.errorCode = errorCode;
        this.httpResponseCode = httpResponseCode;
    }

    /**
     * Creates a new Exception representing an error with the PluralKit API.
     * @param message Descriptive Message
     * @param errorCode PluralKit Error Code
     * @param httpResponseCode HTTP Response Status Code
     * @param cause Exception that caused this exception.
     */
    public PKApiException(String message, int errorCode, int httpResponseCode, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
        this.httpResponseCode = httpResponseCode;
    }

    /**
     * Gets the corresponding PluralKit Error Code.
     * @see <a href="https://pluralkit.me/api/errors/#json-error-codes">PluralKit Error and Status Codes</a>
     * @return Plural Kit Error Code
     */
    public int getErrorCode() {
        return this.errorCode;
    }

    /**
     * Gets the corresponding HTTP Response Code.
     * @see <a href="https://pluralkit.me/api/errors/#json-error-codes">PluralKit Error and Status Codes</a>
     * @return HTTP Response Code
     */
    public int getHttpResponseCode() {
        return this.httpResponseCode;
    }

}
