package com.picpay2.picpay.controllers.dto;

import com.picpay2.picpay.entities.Wallet;
import com.picpay2.picpay.entities.WalletType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record CreateWalletDTO(
        @NotBlank String fullName,
        @NotBlank String cpfCnpj,
        @NotBlank String email,
        @NotBlank String password,
        @NotNull WalletType.Enum walletType
) {
   public Wallet toWallet() {
      return new Wallet(
              this.fullName(),
              this.cpfCnpj(),
              this.email(),
              this.password(),
              this.walletType().get()
      );
   }
}
