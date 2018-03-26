package by.slivki.trainings.config;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionControllerAdvice {

    /**
     * Convert a predefined exception to an HTTP Status code and specify the
     * name of a specific view that will be used to display the error.
     *
     * @return Exception view.
     */
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler({ Exception.class })
    public String databaseError(Exception exception) {
        return "/error";
    }
}