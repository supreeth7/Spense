package com.supreeth.spense.transactions;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

    List<Transaction> findByUserIdAndCategoryId(Integer user_id, Integer cat_id);

    List<Transaction> findByUserId(Integer user_id);

    Transaction findByUserIdAndId(Integer user_id, Integer id);
}
