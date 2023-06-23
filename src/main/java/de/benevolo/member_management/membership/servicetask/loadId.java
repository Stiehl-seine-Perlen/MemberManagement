package de.benevolo.member_management.membership.servicetask;

import de.benevolo.entities.association.Association;

import javax.enterprise.context.ApplicationScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
public class loadId {

    private static final Logger LOGGER = LoggerFactory.getLogger(loadId.class);

    public static Long load(Association association) {
        LOGGER.info("ASSOCIATION: " + association.getAssociationName());
        Long id = association.getId();
        LOGGER.info("ASSOCIATION-ID: " + id);
        return id;
    }
    
}
