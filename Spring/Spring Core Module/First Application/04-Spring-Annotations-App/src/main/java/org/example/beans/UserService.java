package org.example.beans;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    public UserService() {
        System.out.println("UserService :: Constructor");
    }
}
