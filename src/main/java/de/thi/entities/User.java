package de.thi.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "user_entity")
public class User {
    //User with a Username, Password and Email and a unique ID (ID hast to be long)

    @Id
    @GeneratedValue
    private long id;

    @JsonProperty("username")
    @Column(name = "username")
    private String username;
    @JsonProperty("password")
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    @JsonProperty("email")
    private String email;

    public User() {
    }
    @JsonCreator
    public User(@JsonProperty(value = "username") String username,
                @JsonProperty(value = "password") String password,
                @JsonProperty(value = "email") String email)
    {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
