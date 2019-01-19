package net.alientec.pfm.exceptions;

import java.sql.SQLException;

public class PfmSQLException extends Exception {
    private static String msg = "PFM-999998 General SQL exception.";

    public PfmSQLException() {
        super(msg);
    }
    public PfmSQLException(SQLException innerException){
        super(msg, innerException);
    }
    public PfmSQLException(String message) {
        super(msg + " M:" + message);
    }
    public PfmSQLException(String message, SQLException innerException) {
        super(msg + " M:" + message, innerException);
    }
}
