package org.deiv.binarysort.error;

import org.deiv.binarysort.error.client.MalformedInputException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(RestExceptionHandler.class);

    @ExceptionHandler({ MalformedInputException.class })
    public ResponseEntity<?> handleRestException(Exception ex, WebRequest request)
    {
        ResponseStatus annotation = AnnotatedElementUtils.findMergedAnnotation(ex.getClass(), ResponseStatus.class);

        if (annotation == null) {
            log.error(String.format("Excepcion manejada, pero sin información de estado http: %s", ex.toString()));
            log.error("traza: ", ex);

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

        log.error(String.format("Excepcion manejada: %s, code: %s, msg: %s",
                ex.toString(),
                annotation.code(),
                annotation.value()));
        log.error("traza: ", ex);

        return ResponseEntity.status(annotation.code()).body(null);
    }

    @ExceptionHandler({ Exception.class })
    public ResponseEntity<?> handleUnHandledException(Exception ex, WebRequest request)
    {
        log.error(String.format("Excepcion no manejada: %s", ex.toString()));
        log.error("traza: ", ex);

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
}
