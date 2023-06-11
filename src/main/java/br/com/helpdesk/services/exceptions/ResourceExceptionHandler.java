package br.com.helpdesk.services.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
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
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StanderError> validationErrors(MethodArgumentNotValidException ex, HttpServletRequest request){
        
        ValidationError errors = new ValidationError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), "Validation Error", "Erro na validação dos campos", request.getRequestURI());

        for(FieldError x : ex.getBindingResult().getFieldErrors()){
            errors.addError(x.getField(), x.getDefaultMessage());
        }
        
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }

   @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<StanderError> validationErrors(DataIntegrityViolationException ex, HttpServletRequest request){
        StanderError error = new StanderError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), "Violação de dados!", ex.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<StanderError> validationErrors(AccessDeniedException ex, HttpServletRequest request){
        StanderError error = new StanderError(System.currentTimeMillis(), HttpStatus.UNAUTHORIZED.value(),  "Acesso Negado! não tem permissão", ex.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);
    }
}
