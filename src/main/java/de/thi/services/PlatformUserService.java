package de.thi.services;

import de.benevolo.entities.user.PlatformUser;
import de.thi.repositories.PlatformUserRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class PlatformUserService {

    @Inject
    PlatformUserRepository platformUserRepository;

    public PlatformUser getPlatformUserById(Long id){
        return platformUserRepository.findById(id);
    }

    public List<PlatformUser> getAllPlatformUsers(){
        return platformUserRepository.listAll();
    }

    @Transactional
    public PlatformUser persistPlatformUser(PlatformUser platformUser){

        platformUserRepository.persist(platformUser);
        return platformUser;

    }



}
