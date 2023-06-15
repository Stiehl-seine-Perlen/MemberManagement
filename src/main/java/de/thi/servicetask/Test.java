package de.thi.servicetask;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Test {

    public void test(String usernameAndEmail) {
        System.out.println("Process Var is:" + usernameAndEmail);
    }



}
