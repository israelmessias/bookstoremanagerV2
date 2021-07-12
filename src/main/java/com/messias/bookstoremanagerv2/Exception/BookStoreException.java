package com.messias.bookstoremanagerv2.Exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

@ControllerAdvice
public class BookStoreException extends ResponseEntityExceptionHandler {
    /*
    * Caso faça uma busca e não tiver o elemento pesquisado,
    * o erro ira entrar nessa classe e retornara uma resposta customizada*/
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException exception){
        return builderResponseEntity(HttpStatus.NOT_FOUND,
                exception.getMessage(),
                Collections.singletonList(exception.getMessage()));
    }
    @ExceptionHandler(EntityExistsException.class)
    public ResponseEntity<Object> handleEntityExistsException(EntityExistsException exception){
        return builderResponseEntity(HttpStatus.BAD_REQUEST,
                exception.getMessage(),
                Collections.singletonList(exception.getMessage()));
    }
    /*Campos não validos*/
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid
    (MethodArgumentNotValidException exception, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> erros = new ArrayList<>();
        //Erros nos campos
        exception.getBindingResult().getFieldErrors().
                forEach(fieldError -> erros.add
                        ("Field "+ fieldError.getField().toUpperCase()+ " " +fieldError.getDefaultMessage()));
        //Erros a niveis globais
        exception.getBindingResult().getGlobalErrors().
                forEach(globalerror -> erros.add
                        ("Global "+ globalerror.getObjectName()+ " " +globalerror.getDefaultMessage()));
        return builderResponseEntity
                (HttpStatus.BAD_REQUEST, "Informe os argumento(s) Valide o erro(s) ", erros);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable
            (HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return builderResponseEntity
                (HttpStatus.BAD_REQUEST, "JSON malformado", Collections.singletonList(ex.getLocalizedMessage()));
    }

    private ResponseEntity<Object> builderResponseEntity(HttpStatus httpStatus, String message, List<String> erros){
        ApiException apiException = ApiException.builder()
                .code(httpStatus.value())
                .status(httpStatus.getReasonPhrase())
                .message(message)
                .errors(erros)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(httpStatus).body(apiException);
    }

}
