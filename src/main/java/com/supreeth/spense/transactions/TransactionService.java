package com.supreeth.spense.transactions;

import com.supreeth.spense.exceptions.BadRequestException;
import com.supreeth.spense.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    Transaction addTransaction(Transaction transaction, Integer user_id, Integer cat_id) throws BadRequestException {
        try {
            Transaction transaction_obj = new Transaction(
                    transaction.getAmount(),
                    transaction.getNote(),
                    transaction.getTransactionDate(),
                    user_id,
                    cat_id);
            return transactionRepository.save(transaction_obj);
        } catch (Exception e) {
            throw new BadRequestException("Error creating transaction");
        }
    }

    List<Transaction> getAllTransactions(Integer user_id) throws ResourceNotFoundException {
        try {
            List<Transaction> transactions = new ArrayList<>();
            transactions.addAll(transactionRepository.findByUserId(user_id));
            if (transactions.isEmpty()) throw new ResourceNotFoundException("No transactions found");
            return transactions;
        } catch (Exception e) {
            throw new ResourceNotFoundException("No transactions found");
        }
    }

    Transaction getTransaction(Integer user_id, Integer id) throws ResourceNotFoundException {
        try {
            Transaction transaction = transactionRepository.findByUserIdAndId(user_id, id);
            if (transaction == null) throw new ResourceNotFoundException("No transaction found");
            return transaction;
        } catch (Exception e) {
            throw new ResourceNotFoundException("No transaction found");
        }
    }

    List<Transaction> getTransactionsByCategory(Integer user_id, Integer cat_id) {
        try {
            List<Transaction> transactions = new ArrayList<>();
            transactions.addAll(transactionRepository.findByUserIdAndCategoryId(user_id, cat_id));
            if (transactions.isEmpty()) throw new ResourceNotFoundException("No transactions found");
            return transactions;
        } catch (Exception e) {
            throw new ResourceNotFoundException("No transaction found");
        }
    }

    Transaction updateTransaction(Integer user_id, Integer id, Transaction transaction) throws ResourceNotFoundException {
        try {
            Transaction transaction_obj = transactionRepository.findByUserIdAndId(user_id, id);
            if (transaction == null) throw new ResourceNotFoundException("No transaction found");
            transaction_obj.setTransactionDate(transaction.getTransactionDate());
            transaction_obj.setAmount(transaction.getAmount());
            transaction_obj.setNote(transaction.getNote());
            return transactionRepository.save(transaction_obj);
        } catch (Exception e) {
            throw new ResourceNotFoundException("No transaction found");
        }
    }

    public ResponseEntity<Map<String, String>> removeTransaction(Integer user_id, Integer id) throws ResourceNotFoundException {
        try {
            Transaction transaction = transactionRepository.findByUserIdAndId(user_id, id);
            if (transaction == null) throw new ResourceNotFoundException("No transaction found");
            transactionRepository.delete(transaction);
            Map<String, String> m = new HashMap();
            String message = "Deletion successful";
            m.put("message", message);
            return new ResponseEntity<>(m, HttpStatus.OK);
        } catch (Exception e) {
            throw new ResourceNotFoundException("No transaction found");
        }
    }


}
