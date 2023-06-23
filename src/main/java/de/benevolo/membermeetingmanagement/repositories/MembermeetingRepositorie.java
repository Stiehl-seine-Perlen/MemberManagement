package de.benevolo.membermeetingmanagement.repositories;

import de.benevolo.entities.events.Membermeeting;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MembermeetingRepositorie implements PanacheRepository<Membermeeting> {
    // auto implemented
}