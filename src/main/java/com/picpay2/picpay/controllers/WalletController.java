package com.picpay2.picpay.controllers;

import com.picpay2.picpay.controllers.dto.CreateWalletDTO;
import com.picpay2.picpay.entities.Wallet;
import com.picpay2.picpay.services.WalletService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WalletController {
   @Autowired
   private WalletService walletService;

   @PostMapping("/wallets")
   public final ResponseEntity<Wallet> createWallet(@RequestBody @Valid CreateWalletDTO dto) {
      Wallet wallet = this.walletService.createWallet(dto);
      return ResponseEntity.ok(wallet);
   }
}
