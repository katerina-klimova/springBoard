package app.services;

import app.entities.User;
import app.repositories.UserRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepo;

    @Autowired
    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public List<User> getAllUsersServ(){
        return userRepo.getAllUsers();
    }
    public List<User> getNewUsersServ(){
        return userRepo.getNewUsers();
    }

    public User getUserByLogin(String login) throws NotFoundException {
        return userRepo.getUserByLogin(login);
    }
    public void changeStatus(User user){
        userRepo.changeStatus(user);
    }
    public void addUser(User user){
        userRepo.addUser(user);
    }
}
