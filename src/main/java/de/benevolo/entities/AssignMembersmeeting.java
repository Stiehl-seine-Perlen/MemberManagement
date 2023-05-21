package de.benevolo.entities;

import java.time.LocalDateTime;
import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table(name = "membersmeeting")
public class AssignMembersmeeting {

    @Id
    @GeneratedValue
    private Long id;

    /**
     * membersmeeting date
     */
    @JsonProperty("date")
    @Column(name = "date")
    private Date date;

    /**
     * membersmeeting location
     */
    @JsonProperty("location")
    @Column(name = "location")
    private String location;

    /**
     * membersmeeting type
     */
    @JsonProperty("type")
    @Column(name = "type")
    private MembersmeetingType type;

    /**
     * membersmeeting agenda
     */
    @JsonProperty("agenda")
    @Column(name = "agenda")
    private String agenda;

    @JsonProperty("when")
    @Column(name = "created_on")
    @CreationTimestamp
    private LocalDateTime when;

    protected AssignMembersmeeting() {}
    @JsonCreator
    public AssignMembersmeeting(@JsonProperty(value = "date", required = true) Date date,
                                @JsonProperty(value = "location", required = true) String location,
                                @JsonProperty(value = "type", required = true) MembersmeetingType type,
                                @JsonProperty(value = "agenda", required = false) String agenda,
                                @JsonProperty(value = "when", required = true) LocalDateTime when) {
        this.date = date;
        this.location = location;
        this.type = type;
        this.when = when;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public MembersmeetingType getType() {
        return type;
    }

    public void setType(MembersmeetingType type) {
        this.type = type;
    }

    public String getAgenda() {
        return agenda;
    }

    public void setAgenda(String agenda) {
        this.agenda = agenda;
    }

    public LocalDateTime getWhen() {
        return when;
    }

    public void setWhen(LocalDateTime when) {
        this.when = when;
    }
    
}
