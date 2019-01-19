package net.alientec.pfm.exceptions;

public class GeneralPfmException extends Exception {
    private static String msg = "PFM-999999 General PFM exception.";

    public GeneralPfmException() {
        super(msg);
    }
    public GeneralPfmException(Exception innerException){
        super(msg, innerException);
    }
    public GeneralPfmException(String message) {
        super(msg + " M:" + message);
    }
    public GeneralPfmException(String message, Exception innerException) {
        super(msg + " M:" + message, innerException);
    }
}
