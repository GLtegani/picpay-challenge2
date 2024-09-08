package com.picpay2.picpay.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_wallet")
@NoArgsConstructor
@Getter
@Setter
public class Wallet {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String fullName;

   @Column(unique = true)
   private String cpfCnpj;

   @Column(unique = true)
   private String email;
   private String password;
   private BigDecimal balance = BigDecimal.ZERO;
   @ManyToOne
   @JoinColumn(name = "wallet_type_id")
   private WalletType walletType;

   public Wallet(String fullName, String cpfCnpj, String email, String password, WalletType walletType) {
      this.fullName = fullName;
      this.cpfCnpj = cpfCnpj;
      this.email = email;
      this.password = password;
      this.walletType = walletType;
   }

   public final boolean isTransferAllowedForWalletType() {
      return this.walletType.equals(WalletType.Enum.USER.get());
   }

   public final boolean isBalanceEqualOrGreaterThan(BigDecimal value) {
      return this.balance.doubleValue() >= value.doubleValue();
   }

   public final void debit(BigDecimal value) {
      this.balance = this.balance.subtract(value);
   }

   public final void credit(BigDecimal value) {
      this.balance = this.balance.add(value);
   }
}
