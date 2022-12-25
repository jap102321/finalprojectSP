package com.sophfp.sophosfp.dto;

import com.sophfp.sophosfp.entity.Account;

import java.time.LocalDate;

public class TransacDTO {

    private Account account;
    private String transac_type;
    private Double amount;
    private String rec_acc;
    private LocalDate transac_date = LocalDate.now();

    public TransacDTO() {
    }

    public TransacDTO(Account account, String transac_type, Double amount, String rec_acc, LocalDate transac_date) {
        this.account = account;
        this.transac_type = transac_type;
        this.amount = amount;
        this.rec_acc = rec_acc;
        this.transac_date = transac_date;
    }

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

    public String getRec_acc() {
        return rec_acc;
    }

    public void setRec_acc(String rec_acc) {
        this.rec_acc = rec_acc;
    }

    public LocalDate getTransac_date() {
        return transac_date;
    }

    public void setTransac_date(LocalDate transac_date) {
        this.transac_date = transac_date;
    }
}
