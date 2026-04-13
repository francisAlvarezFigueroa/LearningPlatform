package com.duoc.LearningPlatform.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.duoc.LearningPlatform.model.Transaction;
import com.duoc.LearningPlatform.model.TransactionStatus;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByUserId(Long userId);
    List<Transaction> findByStatus(TransactionStatus status);
}
