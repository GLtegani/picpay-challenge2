package com.picpay2.picpay.services;

import com.picpay2.picpay.client.AuthorizationClient;
import com.picpay2.picpay.client.dto.AuthorizationResponseDTO;
import com.picpay2.picpay.controllers.dto.TransferDTO;
import com.picpay2.picpay.entities.Transfer;
import com.picpay2.picpay.exceptions.PicPayException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService {
   @Autowired
   private AuthorizationClient authorizationClient;

   public final boolean isAuthorized(TransferDTO transfer) {
      ResponseEntity<AuthorizationResponseDTO> response = this.authorizationClient.isAuthorized();

      if(response.getStatusCode().isError()) {
         throw new PicPayException();
      }

      return response.getBody().authorized();
   }
}
