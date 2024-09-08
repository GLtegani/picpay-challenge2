package com.picpay2.picpay.exceptions;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

@AllArgsConstructor
public class WalletNotFoundException extends PicPayException{
   private Long walletId;

   @Override
   public final ProblemDetail toProblemDetail() {
      ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);
      problemDetail.setTitle("Wallet not found");
      problemDetail.setDetail("There is no wallet with id " + this.walletId);
      return problemDetail;
   }
}
