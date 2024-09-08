package com.picpay2.picpay.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class TransferNotAllowedForWalletTypeException extends PicPayException{
   @Override
   public final ProblemDetail toProblemDetail() {
      ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);
      problemDetail.setTitle("This wallet type is not allowed to transfer");

      return problemDetail;
   }
}
