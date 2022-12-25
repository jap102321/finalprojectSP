package com.sophfp.sophosfp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @Column(name = "ACCOUNT_ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long acc_id;
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="CLIENT_ID")
    private Client client;

    @Column(name = "ACCOUNTS")
    private String acc_number;
    @Column(name = "ACC_TYPE")
    private String acc_type;
    @Column(name = "BALANCE")
    private Double balance;
    @Column(name = "DATE_DB")
    private LocalDate created_at = LocalDate.now();
    private LocalDate updated_at = LocalDate.now();
    @Column(name = "ACC_STATUS")
    private String acc_status;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<Transaction> transactions = new ArrayList<>();

    public Account(){

    }




    public Account(Client client, String acc_type, String acc_number, Double balance, LocalDate created_at, String acc_status) {
        this.client = client;
        this.acc_type = acc_type;
        this.acc_number = acc_number;
        this.balance = balance;
        this.created_at = created_at;
        this.acc_status = acc_status;
    }

    public Account(LocalDate updated_at){
        this.updated_at = updated_at;
    }

    public Long getAcc_id() {
        return acc_id;
    }

    public void setAcc_id(Long acc_id) {
        this.acc_id = acc_id;
    }
    @JsonBackReference
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getAcc_type() {
        return acc_type;
    }

    public void setAcc_type(String acc_type) {
        this.acc_type = acc_type;
    }
    public String getAcc_number() {
        return acc_number;
    }

    public void setAcc_number(String acc_number) {
        this.acc_number = acc_number;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public LocalDate getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDate created_at) {
        this.created_at = created_at;
    }

    public LocalDate getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDate updated_at) {
        this.updated_at = updated_at;
    }

    public String getAcc_status() {
        return acc_status;
    }

    public void setAcc_status(String acc_status) {
        this.acc_status = acc_status;
    }
    @JsonManagedReference
    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}

