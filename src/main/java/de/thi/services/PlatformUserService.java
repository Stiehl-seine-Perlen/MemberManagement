package de.thi.services;

import com.github.javafaker.Name;
import de.benevolo.entities.global.Address;
import de.benevolo.entities.user.PlatformUser;
import de.thi.repositories.PlatformUserRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

import com.github.javafaker.Faker;
import org.checkerframework.checker.units.qual.A;

@ApplicationScoped
public class PlatformUserService {

    @Inject
    PlatformUserRepository platformUserRepository;

    public PlatformUser getPlatformUserById(Long id){
        PlatformUser platformUser = platformUserRepository.findById(id);
        //TODO: remove this mock later on
        if(platformUser == null) {
            Faker faker = new Faker();
            Name name = faker.name();
            String firstName = name.firstName();
            String lastName = name.lastName();
            platformUser = new PlatformUser(
                    firstName + " " + lastName,
                    firstName.toLowerCase() + "." + lastName.toLowerCase() + "@mock.de"
            );


            platformUser.setAddress(new Address(
                    faker.address().streetName(),
                    faker.address().buildingNumber(),
                    faker.address().zipCode(),
                    faker.address().city(),
                    faker.address().country()
            ));
        }
        return platformUser;
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
