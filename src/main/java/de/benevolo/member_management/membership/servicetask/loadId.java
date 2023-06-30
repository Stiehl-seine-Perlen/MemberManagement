package de.benevolo.member_management.membership.servicetask;

import de.benevolo.entities.association.Association;

import javax.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class loadId {

    public static Long load(Association association) {
        Long id = association.getId();
        return id;
    }
    
}
