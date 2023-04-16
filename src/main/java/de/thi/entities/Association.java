package de.thi.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "association_entity")
public class Association {
    // Association its name, List of Members and role and unique ID

    @Id
    @GeneratedValue
    private long id;

    @JsonProperty("assName")
    @Column(name = "assName")
    private String assName;
   /* @JsonProperty("member")
    @Column(name = "member")
    private List<String> memberList; */
    @Column(name = "role")
    @JsonProperty("role")
    private String role;

    public Association() {
    }
    @JsonCreator
    public Association(@JsonProperty(value = "assName") String assName,
             //   @JsonProperty(value = "member") List<String> memberList,
                @JsonProperty(value = "role") String role)
    {
        this.assName = assName;
       // this.memberList = memberList;
        this.role = role;
    }

    // Getter and Setter

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getAssName() {
        return assName;
    }
    public void setAssName(String assName) {
        this.assName = assName;
    }
  /*  public List<String> getMemberList() {
        return memberList;
    }
    public void setMemberList(List<String> memberList) {
        this.memberList = memberList;
    }  */
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }

    

}
