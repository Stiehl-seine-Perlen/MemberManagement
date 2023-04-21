package de.thi.beans;

import de.thi.entities.User;
import de.thi.rest.UserUpdateAPI;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import javax.inject.Inject;

public class WriteUserData {

    @Inject
    @RestClient
    UserUpdateAPI userUpdateAPI;

    User kermit = new User("kermit", "kermit@demo.de", "12345678");
    User fozzie = new User("fozzie", "fozzie@demo.de", "87654321");

    public void main(String[] args) {
        archive(kermit);
        archive(fozzie);
    }

    public void archive(User user) {
        userUpdateAPI.post(user);
    }

}



