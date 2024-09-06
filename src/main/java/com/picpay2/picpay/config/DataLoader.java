package com.picpay2.picpay.config;

import com.picpay2.picpay.entities.WalletType;
import com.picpay2.picpay.repositories.WalletTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class DataLoader implements CommandLineRunner {
   @Autowired
   private WalletTypeRepository walletTypeRepository;

   @Override
   public void run(String... args) throws Exception {
      Arrays.stream(WalletType.Enum.values()).forEach(walletType -> this.walletTypeRepository.save(walletType.get()));
   }
}
