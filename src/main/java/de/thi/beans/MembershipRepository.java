package de.thi.beans;

import de.thi.entities.Association;
//import io.quarkus.hibernate.reactive.panache.PanacheRepository;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

//Turn Bean ino a CDI Bean

@ApplicationScoped
public class MembershipRepository implements PanacheRepository<Association> {
 // auto implemented
}