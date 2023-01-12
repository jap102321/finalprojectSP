package com.sophfp.sophosfp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
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
    private Long accid;
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="CLIENT_ID")
    private Client client;

    @Column(name = "ACCOUNTS")
    @JoinColumn(name="ACCOUNT_ID")
    private String accNumber;
    @Column(name = "ACC_TYPE")
    private String acc_type;

    @Column(name = "BALANCE")
    private Double balance;
    @Column(name = "DATE_DB")
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    private LocalDate created_at = LocalDate.now();
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    private LocalDate updated_at = LocalDate.now();
    @Column(name = "ACC_STATUS")
    private String acc_status;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<Transaction> transactions = new ArrayList<>();

    public Account(){

    }


    public Account(Client client, String acc_type, String accNumber, Double balance, LocalDate created_at, String acc_status) {
        this.client = client;
        this.acc_type = acc_type;
        this.accNumber = accNumber;
        this.balance = balance;
        this.created_at = created_at;
        this.acc_status = acc_status;
    }

    public Account(LocalDate updated_at){
        this.updated_at = updated_at;
    }

    public Long getAccid() {
        return accid;
    }

    public void setAccid(Long accid) {
        this.accid = accid;
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

    public String getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
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

