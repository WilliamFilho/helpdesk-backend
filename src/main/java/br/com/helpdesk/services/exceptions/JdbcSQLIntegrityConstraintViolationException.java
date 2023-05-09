package br.com.helpdesk.services.exceptions;

public class JdbcSQLIntegrityConstraintViolationException extends RuntimeException{

    public JdbcSQLIntegrityConstraintViolationException(String message) {
        super(message);
    }

    public JdbcSQLIntegrityConstraintViolationException(String message, Throwable cause) {
        super(message, cause);
    }
}
