package org.deiv.binarysort.error.bussines;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason="Server error")
public class LogicException extends RuntimeException {

}