package de.thi.repositories;

import de.benevolo.entities.user.PlatformUser;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PlatformUserRepository implements PanacheRepository<PlatformUser> {
    //auto implemented
}
