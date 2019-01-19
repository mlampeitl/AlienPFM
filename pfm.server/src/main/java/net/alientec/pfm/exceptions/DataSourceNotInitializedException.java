package net.alientec.pfm.exceptions;

public class DataSourceNotInitializedException extends Exception {
    private static String msg = "PFM-990001 DataSource is not initialized. Check application.properties.";

    public DataSourceNotInitializedException() {
        super(msg);
    }
    public DataSourceNotInitializedException(Exception innerException) {
        super(msg, innerException);
    }
    public DataSourceNotInitializedException(String message) {
        super(msg + " M:" + message);
    }
    public DataSourceNotInitializedException(String message, Exception innerException) {
        super(msg + " M:" + message, innerException);
    }
}
