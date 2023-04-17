package de.thi.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_entity")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    /**
     * name of the user
     */
    @JsonProperty("username")
    @Column(name="username")
    private String username;

    /**
     * email adress from user
     */
    @JsonProperty("email")
    @Column(name="email")
    private String email;

    /**
     * password from the user
     */
    @JsonProperty("password")
    @Column(name="password")
    private String password;

    /**
     * telephonenumber from the user
     */
    @JsonProperty("telephonenumber")
    @Column(name="telephonenumber")
    private String telephoneNumber;

    /**
     * birthday from the user
     */
    @JsonProperty("birthday")
    @Column(name="birthday")
    private String birthday;
    

    /**
     * timestamp of creation
     */
    @JsonProperty("when")
    @Column(name="created_on")
    @CreationTimestamp
    private LocalDateTime when;

    public User() {}

    @JsonCreator
    public User(@JsonProperty(value = "username", required = true) String username,
                          @JsonProperty(value = "email", required = true) String email,
                          @JsonProperty(value = "password", required = true) String password,
                          @JsonProperty(value = "birthday", required = true) String birthday,
                          @JsonProperty(value = "telephonenumber", required = false) String telephoneNumber,
                          @JsonProperty(value = "when", required = false) LocalDateTime when) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.birthday = birthday;
        this.telephoneNumber = telephoneNumber;
        this.when = when;
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

     public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public LocalDateTime getWhen() {
        return when;
    }

    public void setWhen(LocalDateTime when) {
        this.when = when;
    }

    @JsonGetter("id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}