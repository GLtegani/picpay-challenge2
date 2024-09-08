package com.picpay2.picpay.repositories;

import com.picpay2.picpay.entities.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TransferRepository extends JpaRepository<Transfer, UUID> {
}
