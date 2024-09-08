package com.picpay2.picpay.services;

import com.picpay2.picpay.controllers.dto.CreateWalletDTO;
import com.picpay2.picpay.entities.Wallet;
import com.picpay2.picpay.exceptions.WalletDataAlreadyExistsException;
import com.picpay2.picpay.exceptions.WalletNotFoundException;
import com.picpay2.picpay.repositories.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WalletService {
   @Autowired
   private WalletRepository repository;

   public final Wallet createWallet(CreateWalletDTO dto) {
      Optional<Wallet> walletDb = this.repository.findByCpfCnpjOrEmail(dto.cpfCnpj(), dto.email());
      if(walletDb.isPresent()) {
         throw new WalletDataAlreadyExistsException("CpfCnpj or Email already exists");
      }
      return this.repository.save(dto.toWallet());
   }

   public final Wallet findById(Long id) {
      return this.repository.findById(id).orElseThrow(() -> new WalletNotFoundException(id));
   }

   public final void save(Wallet wallet) {
      this.repository.save(wallet);
   }
}
