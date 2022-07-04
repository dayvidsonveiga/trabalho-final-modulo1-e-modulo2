package exceptions;

import java.sql.SQLException;

public class DBException extends SQLException {
    public DBException(Throwable msg){
        super(msg);
    }
}