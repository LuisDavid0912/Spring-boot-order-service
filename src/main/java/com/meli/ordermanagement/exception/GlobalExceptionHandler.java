package com.meli.ordermanagement.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.meli.ordermanagement.dto.ErrorResponseDTO;

/**
 * This is our global "Crisis Manager".
 * The @ControllerAdvice annotation allows it to intercept errors
 * from ANY controller in the application.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * This method is activated specifically when a controller argument
     * annotated with @Valid fails validation.
     *
     * @param ex      The exception that contains all the details of the validation error.
     * @param request The original web request that caused the error.
     * @return A clean, standardized error response in JSON format.
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseDTO> handleValidationExceptions(MethodArgumentNotValidException ex, WebRequest request) {
        // We create a map to store the error messages for each field that failed.
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        // We create our custom error response object.
        ErrorResponseDTO errorResponse = new ErrorResponseDTO(
                HttpStatus.BAD_REQUEST.value(),
                "Validation Failed",
                errors,
                request.getDescription(false)
        );

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
