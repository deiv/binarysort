package org.deiv.binarysort.error.client;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason="Malformed Input")
public class MalformedInputException extends RuntimeException {

}