package com.sophfp.sophosfp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @Column(name = "TRANSAC_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trans_id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACCOUNT_ID")
    private Account account;
    @Column(name = "TRANSAC_TYPE")
    private String transac_type;

    @Column(name = "AMOUNT")
    private Double amount;


    @Column(name="TRANSAC_DATE")
    private LocalDate transac_date = LocalDate.now();

    public Transaction(){

    }

    public Transaction(Account account, String transac_type,Double amount, LocalDate transac_date) {
        this.account = account;
        this.transac_type = transac_type;
        this.amount = amount;
        this.transac_date = transac_date;
    }

    public Long getTrans_id() {
        return trans_id;
    }

    public void setTrans_id(Long trans_id) {
        this.trans_id = trans_id;
    }

    @JsonBackReference
    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getTransac_type() {
        return transac_type;
    }

    public void setTransac_type(String transac_type) {
        this.transac_type = transac_type;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }


    public LocalDate getTransac_date() {
        return transac_date;
    }

    public void setTransac_date(LocalDate transac_date) {
        this.transac_date = transac_date;
    }
}
