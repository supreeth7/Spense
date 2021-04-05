package com.supreeth.spense.transactions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/transactions")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @GetMapping("/")
    public List<Transaction> getAll(HttpServletRequest request) {
        int user_id = (Integer) request.getAttribute("user_id");
        List<Transaction> transactions = transactionService.getAllTransactions(user_id);
        return  transactions;
    }

    @GetMapping("{id}")
    public Transaction get(HttpServletRequest request, @PathVariable Integer id) {
        int user_id = (Integer) request.getAttribute("user_id");
        return transactionService.getTransaction(user_id, id);
    }

    @PostMapping("/create/{cat_id}")
    public Transaction create(HttpServletRequest request, @RequestBody Transaction transaction, @PathVariable Integer cat_id) {
        int user_id = (Integer) request.getAttribute("user_id");
        return transactionService.addTransaction(transaction, user_id, cat_id);
    }

    @GetMapping("/category/{cat_id}")
    public List<Transaction> getByCategory(HttpServletRequest request, @PathVariable Integer cat_id) {
        int user_id = (Integer) request.getAttribute("user_id");
        return transactionService.getTransactionsByCategory(user_id, cat_id);
    }

    @PutMapping("{id}")
    public ResponseEntity<Map<String, String>> update(HttpServletRequest request,
                                                      @PathVariable Integer id,
                                                      @RequestBody Transaction transaction) {
        int user_id = (Integer) request.getAttribute("user_id");
        Map<String, String> map = new HashMap<>();
        if (transactionService.updateTransaction(user_id, id, transaction) != null) {
            map.put("message", "updated");
        }
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Map<String, String>> delete(HttpServletRequest request, @PathVariable Integer id) {
        int user_id = (Integer) request.getAttribute("user_id");
        return transactionService.removeTransaction(user_id,id);
    }
}
