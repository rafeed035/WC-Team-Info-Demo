package com.rafeed.wcteaminfodemo.CustomExceptions.ExceptionHandler;

import com.rafeed.wcteaminfodemo.CustomExceptions.ErrorMessage.EntityAlreadyExistsErrorMessage;
import com.rafeed.wcteaminfodemo.CustomExceptions.ErrorMessage.EntityNotFoundErrorMessage;
import com.rafeed.wcteaminfodemo.CustomExceptions.Exceptions.EntityAlreadyExistsException;
import com.rafeed.wcteaminfodemo.CustomExceptions.Exceptions.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler  extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<EntityNotFoundErrorMessage> entityNotFoundException(EntityNotFoundException entityNotFoundException){
        EntityNotFoundErrorMessage entityNotFoundErrorMessage = new EntityNotFoundErrorMessage(HttpStatus.NOT_FOUND,
                entityNotFoundException.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(entityNotFoundErrorMessage);
    }

    @ExceptionHandler(EntityAlreadyExistsException.class)
    public ResponseEntity<EntityAlreadyExistsErrorMessage> entityAlreadyExistsException(EntityAlreadyExistsException entityAlreadyExistsException){
        EntityAlreadyExistsErrorMessage entityAlreadyExistsErrorMessage = new EntityAlreadyExistsErrorMessage(HttpStatus.CONFLICT,
                entityAlreadyExistsException.getMessage());

        return ResponseEntity.status(HttpStatus.CONFLICT).body(entityAlreadyExistsErrorMessage);
    }
}
