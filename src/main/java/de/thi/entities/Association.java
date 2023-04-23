package de.thi.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.persistence.*;

//import org.hibernate.mapping.List;

@Entity
@Table(name = "association_entity")
public class Association {

    // region Fields
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long associationId;

    
    private String name;

   
    private String businessmail;

  
    private String password;

   
    private LocalDateTime created;

    
    private ArrayList<String> memberList;
    // endregion

    // region Constructors
    public Association() {}

    
    public Association(String name, String mail, String password, ArrayList<String> memberList)
    {
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
