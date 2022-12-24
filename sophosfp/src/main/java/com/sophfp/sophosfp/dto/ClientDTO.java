package com.sophfp.sophosfp.dto;

import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class ClientDTO {

    private String idType;
    private String name;
    private String lastname;
    private Long document;
    private String email;
    private LocalDate birthDate;
    private LocalDate creationDate = LocalDate.now();
    private LocalDate updateDate = LocalDate.now();
    private String updateUser;


    public ClientDTO(String idType, String name, String lastname,Long document, String email, LocalDate birthDate) {
        this.idType = idType;
        this.name = name;
        this.lastname = lastname;
        this.document = document;
        this.email = email;
        this.birthDate = birthDate;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public Long getDocument() {
        return document;
    }

    public void setDocument(Long document) {
        this.document = document;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
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


}

