package com.supreeth.spense.transactions;

import com.supreeth.spense.category.Category;
import com.supreeth.spense.user.User;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "cat_id")
    private Category category;

    private Double amount;
    private String note;

    @Temporal(TemporalType.DATE)
    private Date transactionDate;

    public Transaction() {
    }

    public Transaction(Double amount, String note, Date transactionDate, Integer user_id, Integer cat_id) {
        this.id = id;
        this.amount = amount;
        this.note = note;
        this.transactionDate = transactionDate;
        this.user = new User(user_id);
        this.category = new Category(cat_id);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", amount=" + amount +
                ", note='" + note + '\'' +
                ", transactionDate=" + transactionDate +
                '}';
    }
}
