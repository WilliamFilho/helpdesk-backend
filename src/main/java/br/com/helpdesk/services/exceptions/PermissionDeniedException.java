package br.com.helpdesk.services.exceptions;

public class PermissionDeniedException extends RuntimeException{

    public PermissionDeniedException(String message) {
        super(message);
    }
}
