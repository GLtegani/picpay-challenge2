package com.picpay2.picpay.exceptions;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

@AllArgsConstructor
public class WalletDataAlreadyExistsException extends PicPayException{
   private String detail;

   @Override
   public final ProblemDetail toProblemDetail() {
      ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);
      problemDetail.setTitle("Wallet data already exists");
      problemDetail.setDetail(this.detail);
      return problemDetail;
   }
}
