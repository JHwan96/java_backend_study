package com.example.validation.exception;

import com.example.validation.model.Api;
import com.example.validation.model.UserRegisterRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestControllerAdvice
public class ValidationExceptionHandler {

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResponseEntity<Api> validationException(MethodArgumentNotValidException e) {
        log.error("", e);
        List<String> errorMessageList = e.getFieldErrors().stream()
                .map(x -> String.format("%s : { %s } 은 %s", x.getField(), x.getRejectedValue(), x.getDefaultMessage()))
                .collect(Collectors.toList());

        Api.Error error = Api.Error.builder()
                .errorMessage(errorMessageList)
                .build();

        Api<UserRegisterRequest> errorResponse = Api.<UserRegisterRequest>builder()
                .resultCode(String.valueOf(HttpStatus.BAD_REQUEST.value()))
                .resultMessage(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .error(error)
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(errorResponse);
    }
}
