package com.sophfp.sophosfp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @Column(name = "ACCOUNT_ID")
    private Long acc_id;
    @Column(name = "UID")
    private Client client;
    @Column(name = "ACCOUNTS")
    private String acc_number;
    private String acc_name;
    private String acc_type;
    @Column(name = "BALANCE")
    private Double balance;
    @Column(name = "DATE_DB")
    private LocalDate created_at = LocalDate.now();
    private LocalDate updated_at = LocalDate.now();


    private List<Client> clients = new ArrayList<>();
    public Account(){

    }

    public Long getAcc_id() {
        return acc_id;
    }

    public void setAcc_id(Long acc_id) {
        this.acc_id = acc_id;
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

    public String getAcc_name() {
        return acc_name;
    }

    public void setAcc_name(String acc_name) {
        this.acc_name = acc_name;
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

    public List<Client> getClients(){
        return clients;
    }

    public void setClients(List<Client> clients){
        this.clients = clients;
    }


}
