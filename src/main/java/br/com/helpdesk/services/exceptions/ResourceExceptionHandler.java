package br.com.helpdesk.services.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {
    @ExceptionHandler(ObjectnotFoundException.class)
    public ResponseEntity<StanderError> objectnotFoundException(ObjectnotFoundException ex, HttpServletRequest request){
        StanderError error = new StanderError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), "Object Not Found", ex.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(JdbcSQLIntegrityConstraintViolationException.class)
    public ResponseEntity<StanderError> jdbcSQLIntegrityConstraintViolationException(JdbcSQLIntegrityConstraintViolationException ex, HttpServletRequest request){
        StanderError error = new StanderError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), "Violação de dados!", ex.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
