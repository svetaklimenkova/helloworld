package by.slivki.trainings.config;

import by.slivki.trainings.exception.RestException;
import by.slivki.trainings.util.RestMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Locale;

@ControllerAdvice
public class RestExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(RestExceptionHandler.class);
    private static final String DEBUG_MESSAGE = "ERROR %d: %s";

    @Autowired
    private MessageSource messageSource;

    /**
     * Convert a predefined exception to an HTTP Status code and specify the
     * name of a specific view that will be used to display the error.
     */
    @ExceptionHandler(RestException.class)
    public ResponseEntity<RestMessage> handleRestException(RestException ex, Locale locale) {
        int code = ex.getCode();
        String errorMessage = messageSource.getMessage(ex.getMessage(), ex.getArgs(), locale);

        logger.error(String.format(DEBUG_MESSAGE, code, errorMessage));

        return new ResponseEntity<>(new RestMessage(code, errorMessage), HttpStatus.BAD_REQUEST);
    }
}