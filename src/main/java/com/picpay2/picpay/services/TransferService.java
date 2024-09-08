package com.picpay2.picpay.services;

import com.picpay2.picpay.controllers.dto.TransferDTO;
import com.picpay2.picpay.entities.Transfer;
import com.picpay2.picpay.entities.Wallet;
import com.picpay2.picpay.exceptions.InsufficientBalanceException;
import com.picpay2.picpay.exceptions.TransferNotAllowedForWalletTypeException;
import com.picpay2.picpay.exceptions.TransferNotAuthorizedException;
import com.picpay2.picpay.repositories.TransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class TransferService {
   @Autowired
   private AuthorizationService authorizationService;
   @Autowired
   private NotificationService notificationService;
   @Autowired
   private TransferRepository repository;
   @Autowired
   private WalletService walletService;

   public final Transfer transfer(TransferDTO transferDTO) {
      Wallet sender = this.walletService.findById(transferDTO.payer());
      Wallet receiver = this.walletService.findById(transferDTO.payee());

      this.validateTransfer(transferDTO, sender);

      sender.debit(transferDTO.value());
      receiver.credit(transferDTO.value());

      Transfer transfer = new Transfer(sender, receiver, transferDTO.value());
      this.walletService.save(sender);
      this.walletService.save(receiver);
      Transfer transferResult = this.repository.save(transfer);

      CompletableFuture.runAsync(() -> this.notificationService.sendNotification(transferResult));
      return transferResult;
   }

   private void validateTransfer(TransferDTO transferDTO, Wallet sender) {
      if(!sender.isTransferAllowedForWalletType()) {
         throw new TransferNotAllowedForWalletTypeException();
      }

      if(!sender.isBalanceEqualOrGreaterThan(transferDTO.value())) {
         throw new InsufficientBalanceException();
      }

      if(!this.authorizationService.isAuthorized(transferDTO)) {
         throw new TransferNotAuthorizedException();
      }
   }
}
