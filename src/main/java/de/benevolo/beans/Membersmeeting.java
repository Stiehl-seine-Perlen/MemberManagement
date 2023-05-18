package de.benevolo.beans;

import de.benevolo.entities.AssignMembersmeeting;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Membersmeeting implements PanacheRepository<AssignMembersmeeting> {
    // auto implemented
}