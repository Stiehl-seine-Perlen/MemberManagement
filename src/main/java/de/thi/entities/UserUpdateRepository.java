package de.thi.entities;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserUpdateRepository implements PanacheRepository<User> {
    // auto implemented
}