package exceptionhandlers;

import exceptions.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
@Component
public class GlobalExceptionHandler {

    private final MessageSource messageSource;

    public GlobalExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus
    public String defaultErrorHandler(HttpServletRequest request, Exception exception) throws Exception {
        return exception.getMessage();
    }

    @ExceptionHandler(CustomException.class)
    @ResponseStatus
    public String handleMyException(HttpServletRequest request, CustomException exception) throws Exception {
        // you may want to translate a message code in the request.getLocale()
        String userMessage = messageSource.getMessage(exception.getErrorCode().name(), null, request.getLocale());
        return userMessage;
    }
}
