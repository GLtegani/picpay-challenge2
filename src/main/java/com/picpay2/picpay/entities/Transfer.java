package com.picpay2.picpay.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "tb_transfer")
@NoArgsConstructor
@Getter
@Setter
public class Transfer {
   @Id
   @GeneratedValue(strategy = GenerationType.UUID)
   private UUID id;
   @ManyToOne
   @JoinColumn(name = "wallet_sender_id")
   private Wallet sender;
   @ManyToOne
   @JoinColumn(name = "wallet_receiver_id")
   private Wallet receiver;
   private BigDecimal value;

   public Transfer(Wallet sender, Wallet receiver, BigDecimal value) {
      this.sender = sender;
      this.receiver = receiver;
      this.value = value;
   }
}
