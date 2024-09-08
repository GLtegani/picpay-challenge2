package com.picpay2.picpay.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_wallet_type")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class WalletType {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String description;

   @AllArgsConstructor
   public enum Enum {
      USER(1L, "user"),
      MERCHANT(2L, "merchant");

      private final Long id;
      private final String description;

      public final WalletType get() {
         return new WalletType(id, description);
      }
   }
}
