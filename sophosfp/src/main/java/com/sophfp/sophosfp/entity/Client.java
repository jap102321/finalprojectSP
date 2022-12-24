package com.sophfp.sophosfp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "CLIENT_TABLE")
public class Client implements Serializable {
    @Id
    @Column(name = "CLIENT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "ID_TYPE")
    private String idType;
    @Column(name="NAME")
    private String name;
    @Column(name = "LAST_NAME")
    private String lastname;
    @Column (name = "DOCUMENT")
    private Long document;
    @Column(name="EMAIL")
    private String email;
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    @Column(name = "BIRTH_DATE")
    private LocalDate birthDate;
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)

    @Column(name = "CREATION_DATE")
    private LocalDate creationDate = LocalDate.now();
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)

    @Column(name="UPDATE_DATE")
    private LocalDate updateDate = LocalDate.now();

    @Column(name = "UPDATE_USER")
    private String updateUser;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Account> accounts = new ArrayList<>();

    public Client(){

    }

    public Client(String idType, String name, String lastname, Long document, String email, LocalDate birthDate, LocalDate creationDate) {
        this.idType = idType;
        this.name = name;
        this.lastname = lastname;
        this.document = document;
        this.email = email;
        this.birthDate = birthDate;
        this.creationDate = creationDate;
    }

    public Client(LocalDate updateDate, String updateUser){
        this.updateDate = updateDate;
        this.updateUser = updateUser;
    }




    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public long getDocument() {
        return document;
    }

    public void setDocument(long document) {
        this.document = document;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDate updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    @JsonManagedReference
    public List<Account> getAccounts(){
        return accounts;
    }

    public void setAccounts(List<Account> accounts){
        this.accounts = accounts;
    }
}

