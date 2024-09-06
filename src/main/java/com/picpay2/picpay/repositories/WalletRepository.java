package com.picpay2.picpay.repositories;

import com.picpay2.picpay.entities.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WalletRepository extends JpaRepository<Wallet, Long> {
   Optional<Wallet> findByCpfCnpjOrEmail(String cpfCnpj, String email);
}
