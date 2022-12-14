package com.rafeed.wcteaminfodemo.CustomExceptions.ErrorMessage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntityAlreadyExistsErrorMessage {
    private HttpStatus httpStatus;
    private String message;
}
