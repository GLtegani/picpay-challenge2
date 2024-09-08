package com.picpay2.picpay.controllers;

import com.picpay2.picpay.controllers.dto.TransferDTO;
import com.picpay2.picpay.entities.Transfer;
import com.picpay2.picpay.services.TransferService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransferController {
   @Autowired
   private TransferService transferService;

   @PostMapping("/transfer")
   public ResponseEntity<Transfer> transfer(@RequestBody @Valid TransferDTO dto) {
      Transfer response = this.transferService.transfer(dto);
      return ResponseEntity.ok(response);
   }
}
