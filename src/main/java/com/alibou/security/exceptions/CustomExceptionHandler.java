package com.alibou.security.exceptions;

import com.alibou.security.payload.ExceptionResponse;
import com.alibou.security.payload.GenericResponse;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.http.*;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class CustomExceptionHandler {
//    @ExceptionHandler(Exception.class)
//    public ProblemDetail handleSecurityException(Exception ex){
//        ProblemDetail detail = null;
//        if(ex instanceof BadCredentialsException){
//            detail = ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(401),ex.getMessage());
//
//        }
//        if(ex instanceof AccessDeniedException){
//            detail = ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(403),ex.getMessage());
//
//        }
//        if(ex instanceof SignatureException){
//            detail = ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(403),ex.getMessage());
//
//        }
//        if(ex instanceof ExpiredJwtException){
//            detail = ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(403),ex.getMessage());
//
//        }
//
//        return detail;
//    }
@ExceptionHandler(value = {UsernameNotFoundException.class})
public ResponseEntity<Object> handleExpiredJwtException(UsernameNotFoundException ex, WebRequest request) {
    String requestUri = ((ServletWebRequest) request).getRequest().getRequestURI().toString();
    ExceptionResponse exceptionMessage = new ExceptionResponse(ex.getMessage(), requestUri);
//        return new ResponseEntity<>(exceptionMessage, new HttpHeaders(), HttpStatus.FORBIDDEN);
    return new ResponseEntity<>(GenericResponse.error(exceptionMessage.getMessage(), 403), new HttpHeaders(), HttpStatus.FORBIDDEN);
}
    @ExceptionHandler(value = {ExpiredJwtException.class})
    public ResponseEntity<Object> handleExpiredJwtException(ExpiredJwtException ex, WebRequest request) {
        String requestUri = ((ServletWebRequest) request).getRequest().getRequestURI().toString();
        ExceptionResponse exceptionMessage = new ExceptionResponse(ex.getMessage(), requestUri);
//        return new ResponseEntity<>(exceptionMessage, new HttpHeaders(), HttpStatus.FORBIDDEN);
        return new ResponseEntity<>(GenericResponse.error(exceptionMessage.getMessage(), 403), new HttpHeaders(), HttpStatus.FORBIDDEN);
    }
    @ExceptionHandler(value = {SignatureException.class})
    public ResponseEntity<Object> handleExpiredJwtException(SignatureException ex, WebRequest request) {
        String requestUri = ((ServletWebRequest) request).getRequest().getRequestURI().toString();
        ExceptionResponse exceptionMessage = new ExceptionResponse(ex.getMessage(), requestUri);
//        return new ResponseEntity<>(exceptionMessage, new HttpHeaders(), HttpStatus.FORBIDDEN);
        return new ResponseEntity<>(GenericResponse.error(exceptionMessage.getMessage(), 403), new HttpHeaders(), HttpStatus.FORBIDDEN);
    }
    @ExceptionHandler(value = {BadCredentialsException.class})
    public ResponseEntity<Object> handleExpiredJwtException(BadCredentialsException ex, WebRequest request) {
        String requestUri = ((ServletWebRequest) request).getRequest().getRequestURI().toString();
        ExceptionResponse exceptionMessage = new ExceptionResponse(ex.getMessage(), requestUri);
//        return new ResponseEntity<>(exceptionMessage, new HttpHeaders(), HttpStatus.FORBIDDEN);
        return new ResponseEntity<>(GenericResponse.error(exceptionMessage.getMessage(), 403), new HttpHeaders(), HttpStatus.FORBIDDEN);
    }
    @ExceptionHandler(value = {AccessDeniedException.class})
    public ResponseEntity<Object> handleExpiredJwtException(AccessDeniedException ex, WebRequest request) {
        String requestUri = ((ServletWebRequest) request).getRequest().getRequestURI().toString();
        ExceptionResponse exceptionMessage = new ExceptionResponse(ex.getMessage(), requestUri);
//        return new ResponseEntity<>(exceptionMessage, new HttpHeaders(), HttpStatus.FORBIDDEN);
        return new ResponseEntity<>(GenericResponse.error(exceptionMessage.getMessage(), 403), new HttpHeaders(), HttpStatus.FORBIDDEN);
    }
    @ExceptionHandler(value = {MalformedJwtException.class})
    public ResponseEntity<Object> handleExpiredJwtException(MalformedJwtException ex, WebRequest request) {
        String requestUri = ((ServletWebRequest) request).getRequest().getRequestURI().toString();
        ExceptionResponse exceptionMessage = new ExceptionResponse(ex.getMessage(), requestUri);
//        return new ResponseEntity<>(exceptionMessage, new HttpHeaders(), HttpStatus.FORBIDDEN);
        return new ResponseEntity<>(GenericResponse.error(exceptionMessage.getMessage(), 403), new HttpHeaders(), HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(value = {UnsupportedJwtException.class})
    public ResponseEntity<Object> handleExpiredJwtException(UnsupportedJwtException ex, WebRequest request) {
        String requestUri = ((ServletWebRequest) request).getRequest().getRequestURI().toString();
        ExceptionResponse exceptionMessage = new ExceptionResponse(ex.getMessage(), requestUri);
//        return new ResponseEntity<>(exceptionMessage, new HttpHeaders(), HttpStatus.FORBIDDEN);
        return new ResponseEntity<>(GenericResponse.error(exceptionMessage.getMessage(), 403), new HttpHeaders(), HttpStatus.FORBIDDEN);
    }
    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleOtherExceptions(Exception ex, WebRequest request) {
        String requestUri = ((ServletWebRequest) request).getRequest().getRequestURI().toString();
        ExceptionResponse exceptionMessage = new ExceptionResponse(ex.getMessage(), requestUri);
        return new ResponseEntity<>(exceptionMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
