package com.picpay2.picpay.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class InsufficientBalanceException extends PicPayException{
   @Override
   public final ProblemDetail toProblemDetail() {
      ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);

      problemDetail.setTitle("Insufficient balance");
      problemDetail.setDetail("You cannot transfer a value bigger than your current");

      return problemDetail;
   }
}
