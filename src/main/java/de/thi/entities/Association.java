package de.thi.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.persistence.*;

//import org.hibernate.mapping.List;

@Entity
@Table(name = "association_entity")
public class Association {

    // region Fields
    @Id
    @GeneratedValue
    private Long associationId;

    @JsonProperty("name")
    @Column(name = "name")
    private String name;

    @JsonProperty("businessmail")
    @Column(name = "businessmail")
    private String businessmail;

    @JsonProperty("password")
    @Column(name = "password")
    private String password;

    @JsonProperty("created")
    @Column(name = "created")
    private LocalDateTime created;

    @JsonProperty("memberList")
    @Column(name = "memberList")
    private ArrayList<String> memberList;
    // endregion

    // region Constructors
    public Association() {}

    @JsonCreator
    public Association(@JsonProperty(value = "name", required = true) String name,
                       @JsonProperty(value = "businessmail", required = true) String mail,
                       @JsonProperty(value = "password", required = true) String password,
                       @JsonProperty(value = "memberList", required = true) ArrayList<String> memberList) {
        this.name = name;
        this.businessmail = mail;
        this.password = password;
        this.memberList = memberList;
    }


    public Long getAssociationId() {
        return associationId;
    }

    public void setAssociationId(Long associationId) {
        this.associationId = associationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBusinessmail() {
        return businessmail;
    }

    public void setBusinessmail(String businessmail) {
        this.businessmail = businessmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public ArrayList<String> getMemberList() {
        return memberList;
    }

    public void setMemberList(ArrayList<String> memberList) {
        this.memberList = memberList;
    }

}
