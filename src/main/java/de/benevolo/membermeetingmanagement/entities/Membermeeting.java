package de.benevolo.membermeetingmanagement.entities;

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
@Table(name = "membermeeting")
public class Membermeeting {

    @Id
    @GeneratedValue
    private Long membermeetingId;

    /**
     * membersmeeting date
     */
    @JsonProperty("date")
    @Column(name = "date")
    private Date date;

    /**
     * membermeeting time
     */
    @JsonProperty("time")
    @Column(name = "time")
    private String time;

    /**
     * membersmeeting location
     */
    @JsonProperty("location")
    @Column(name = "location")
    private String location;

    /**
     * from which assosiation
     */
    @JsonProperty("ownedByAssociationId")
    @Column(name = "ownedByAssociationId")
    private Long ownedByAssociationId;

    /**
     * membersmeeting type
     */
    @JsonProperty("isClosed")
    @Column(name = "isClosed")
    private Boolean isClosed;

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

    public Membermeeting() {}
    @JsonCreator
    public Membermeeting(@JsonProperty(value = "location", required = true) String location,
                                @JsonProperty(value = "date", required = true) Date date,
                                @JsonProperty(value = "time", required = true) String time,
                                @JsonProperty(value = "ownedByAssociationId", required = true) Long ownedByAssociationId,
                                @JsonProperty(value = "isClosed", required = true) Boolean isClosed,
                                @JsonProperty(value = "agenda", required = false) String agenda,
                                @JsonProperty(value = "when", required = true) LocalDateTime when) {
        this.location = location;
        this.isClosed = isClosed;
        this.ownedByAssociationId = ownedByAssociationId;
        this.date = date;
        this.time = time;
        this.agenda = agenda;
        this.when = when;
    }

    public Long getMembermeetingId() {
        return membermeetingId;
    }

    public void setMembermeetingId(Long membermeetingId) {
        this.membermeetingId = membermeetingId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

      public Long getOwnedByAssociationId() {
        return ownedByAssociationId;
    }

    public void setOwnedByAssociationId(Long ownedbyAssosiation) {
        this.ownedByAssociationId = ownedbyAssosiation;
    }

    public Boolean getIsClosed() {
        return isClosed;
    }

    public void setIsClosed(Boolean isClosed) {
        this.isClosed = isClosed;
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
