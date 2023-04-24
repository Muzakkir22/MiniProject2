package vttp.csf.MiniProject2.Server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vttp.csf.MiniProject2.Server.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class SQLservice {
    
    @Autowired
    UserRepo userRepo;
 
    public String hello(String email) {

        String password = userRepo.getUsersByEmail(email);

        return password;
    }
    
    public String getImage(String location) {

        return userRepo.getImage(location);
    }
}
