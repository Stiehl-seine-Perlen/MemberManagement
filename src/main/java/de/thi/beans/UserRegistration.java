package de.thi.beans;

import de.thi.entities.User;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserRegistration implements PanacheRepository<User> {
 // auto implemented
}
