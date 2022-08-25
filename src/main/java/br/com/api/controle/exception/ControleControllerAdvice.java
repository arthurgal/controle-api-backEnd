package br.com.api.controle.exception;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.List;

@ControllerAdvice(basePackages = "br.com.api.controle")
public class ControleControllerAdvice extends ResponseEntityExceptionHandler {

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ResponseEntity<MessageExceptionHandler> AllExceptions(Exception exception, WebRequest request){
        MessageExceptionHandler error = new MessageExceptionHandler(
                new Date(),
                exception.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        BindingResult result = ex.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();

        StringBuilder stringBuilder = new StringBuilder("Os campos seguintes não podem ser nulos: ");
        for (FieldError fieldError : fieldErrors){
            stringBuilder.append(" | ");
            stringBuilder.append(" -> ");
            stringBuilder.append(fieldError.getField());
            stringBuilder.append(" <- ");
        }

        MessageExceptionHandler error = new MessageExceptionHandler(
                new Date(), stringBuilder.toString(), request.getDescription(false));
        return new ResponseEntity<>(error, status);

    }

}
