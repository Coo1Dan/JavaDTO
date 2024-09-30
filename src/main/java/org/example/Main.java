package org.example;

import org.example.generation.UserGenerator;
import org.example.models.User;

public class Main {

    public static void main(String[] args) {
        // #1
        // create and fill object
        User randomUser = UserGenerator.generateUser();
        System.out.println(randomUser);

        //#2
        // fill an existing object
        User Alex = new User();
        Alex.setName("ALEX");
        System.out.println(Alex);
        User fillAlex = UserGenerator.fillUser(Alex);
        System.out.println(fillAlex);
    }
}