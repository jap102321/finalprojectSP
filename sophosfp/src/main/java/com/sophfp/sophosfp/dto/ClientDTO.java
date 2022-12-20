package com.sophfp.sophosfp.dto;

import jakarta.persistence.Column;

import java.util.Date;

public class ClientDTO {

    private String name;
    private String lastname;
    private String email;
    private Date birthDate;
    private Date updateDate;
    private String updateUser;


    public ClientDTO(Long id, String name, String lastname, String email, Date birthDate, Date updateDate, String updateUser) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.birthDate = birthDate;
        this.updateDate = updateDate;
        this.updateUser = updateUser;
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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }
}
