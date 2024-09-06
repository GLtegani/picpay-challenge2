package com.picpay2.picpay.controllers;

import com.picpay2.picpay.exceptions.PicPayException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class RestExceptionHandler {
   @ExceptionHandler(PicPayException.class)
   public final ProblemDetail handlePicPayException(PicPayException e) {
      return e.toProblemDetail();
   }

   @ExceptionHandler(MethodArgumentNotValidException.class)
   public final ProblemDetail handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
      List<InvalidParam> fieldErros = e.getFieldErrors()
              .stream()
              .map(f -> new InvalidParam(f.getField(), f.getDefaultMessage()))
              .toList();

      ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
      problemDetail.setTitle("Your request parameters didn't validate");
      problemDetail.setProperty("invalid-params", fieldErros);

      return problemDetail;
   }

   private record InvalidParam(String name, String reason){}
}
