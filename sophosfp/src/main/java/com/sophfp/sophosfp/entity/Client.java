package com.sophfp.sophosfp.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "CLIENT_TABLE")
public class Client implements Serializable {
    @Id
    @Column(name = "CLIENT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="NAME")
    private String name;
    @Column(name = "LAST_NAME")
    private String lastname;
    @Column(name="EMAIL")
    private String email;
    @Column(name = "BIRTH_DATE")
    private Date birthDate;
    @Column(name="UPDATE_DATE")
    private Date updateDate;
    @Column(name = "UPDATE_USER")
    private String updateUser;

    public Client(){

    }

    public Client(Long id, String name, String lastname, String email, Date birthDate, Date updateDate, String updateUser) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.birthDate = birthDate;
        this.updateDate = updateDate;
        this.updateUser = updateUser;
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
