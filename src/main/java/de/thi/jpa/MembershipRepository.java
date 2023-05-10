package de.thi.jpa;

import de.benevolo.entities.association.Membership;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

//Turn Bean ino a CDI Bean
@ApplicationScoped
public class MembershipRepository implements PanacheRepository<Membership> {
 // auto implemented
}