package de.thi.entities;

//import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Table;
//import org.hibernate.annotations.CreationTimestamp;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
@Table(name = "User_entity")
public class User extends PanacheEntity{

    private String username;
    private String email;
    private String password;
    //private String telephoneNumber;
    //private String birthday;

    public User() {
        //no args
    }

    
    public User(String username, String password, String email) {
        this.username = username;
        this.email = email;
        this.password = password;
        //this.birthday = birthday;
        //this.telephoneNumber = telephoneNumber;
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //  public String getBirthday() {
    //     return birthday;
    // }

    // public void setBirthday(String birthday) {
    //     this.birthday = birthday;
    // }

    // public String getTelephoneNumber() {
    //     return telephoneNumber;
    // }

    // public void setTelephoneNumber(String telephoneNumber) {
    //     this.telephoneNumber = telephoneNumber;
    // }

}