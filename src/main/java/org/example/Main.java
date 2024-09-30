package org.example;

import org.example.generation.UserGenerator;
import org.example.models.User;

public class Main {

    private final UserGenerator userGenerator = new UserGenerator();

    public static void main(String[] args) {
        // #1
        // create and fill object
        User randomUser = generateUser();
        System.out.println(randomUser.toString());

        //#2
        // fill an existing object
        User Fedotov = new User().setName("FEDOTOV");
        User fillFedotov = fillUser(Fedotov);
        System.out.println(fillFedotov.toString());
    }
}