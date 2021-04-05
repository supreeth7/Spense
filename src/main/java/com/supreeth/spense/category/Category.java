package com.supreeth.spense.category;

import com.supreeth.spense.transactions.Transaction;
import com.supreeth.spense.user.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    private String description;

    @Transient
    private Double total_expense = 0.0;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy="category")
    private List<Transaction> transactions = new ArrayList<>();

    public Category() {
    }

    public Category(Integer id) {
        this.id = id;
    }

    public Category(String title, String description, Integer userId) {
        this.title = title;
        this.description = description;
        this.user = new User(userId);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getTotal_expense() {
        return total_expense;
    }

    public void setTotal_expense(Double total_expense) {
        this.total_expense = total_expense;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", total_expense=" + total_expense + '\'' +
                '}';
    }
}
