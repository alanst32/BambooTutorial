package com.skoogle.desktop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * @author alanterriaga
 * @project skoogle-desktop
 */
public class AccessDeniedException extends Exception {

    public AccessDeniedException(String message) {
        super(message);
    }

    public static ResponseEntity AccessDeniedResponse(Exception ex) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Api-Key header missing or wrong scheme chosen");
    }

}