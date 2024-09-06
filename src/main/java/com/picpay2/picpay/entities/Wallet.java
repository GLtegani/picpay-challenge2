package com.picpay2.picpay.entities;

import jakarta.persistence.*;
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
}
