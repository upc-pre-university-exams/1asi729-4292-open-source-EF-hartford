package org.hign.platform.u202318274.shared.domain.exceptions;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionMiddleware {
    public record ErrorResponse(String error, String code) {
    }

    @ExceptionHandler(GeneralException.class)
    public ResponseEntity<ErrorResponse> handleGeneralException(GeneralException ex) {
        return new ResponseEntity<>(new ErrorResponse(ex.getMessage(), ex.getCode()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorResponse> handleDataIntegrity(DataIntegrityViolationException ex) {
        return new ResponseEntity<>(new ErrorResponse("Data integrity violation", "DATA_INTEGRITY_ERROR"), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleUnexpected(Exception ex) {
        return new ResponseEntity<>(new ErrorResponse("Unexpected error", "INTERNAL_ERROR"), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
