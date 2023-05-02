package de.thi.jpa;

import de.thi.entities.Association;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

//Turn Bean ino a CDI Bean

@ApplicationScoped
public class ApplicationRepository implements PanacheRepository<Association> {
 // auto implemented
}