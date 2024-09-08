package com.picpay2.picpay.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class TransferNotAuthorizedException extends PicPayException{
   @Override
   public final ProblemDetail toProblemDetail() {
      ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);

      problemDetail.setTitle("Transfer not authorized");
      problemDetail.setDetail("Authorization service not authorized this transfer");

      return problemDetail;
   }
}
