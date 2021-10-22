package com.freecharge.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="No negative Value Allowed")  
public class InvalidInputException extends RuntimeException {
    
}