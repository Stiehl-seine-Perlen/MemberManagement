package de.thi.jpa;

import de.thi.entities.User;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

//Turn Bean ino a CDI Bean
@ApplicationScoped
public class UserRegistration implements PanacheRepository<User> {
 // auto implemented
}