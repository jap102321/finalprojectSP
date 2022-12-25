package com.sophfp.sophosfp.dto;

import com.sophfp.sophosfp.entity.Client;
import jakarta.persistence.Column;

import java.time.LocalDate;

public class AccountDTO {

    private Client client;
    private String acc_number;
    private String acc_type;
    private Double balance;
    private LocalDate created_at = LocalDate.now();
    private LocalDate updated_at = LocalDate.now();
    private String acc_status;


    public AccountDTO(Client client, String acc_type, Double balance, String acc_status) {
        this.client = client;
        this.acc_type = acc_type;
        this.balance = balance;
        this.acc_status = acc_status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getAcc_number() {
        return acc_number;
    }

    public void setAcc_number(String acc_number) {
        this.acc_number = acc_number;
    }

    public String getAcc_type() {
        return acc_type;
    }

    public void setAcc_type(String acc_type) {
        this.acc_type = acc_type;
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
}
