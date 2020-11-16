package technicalblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import technicalblog.model.User;
import technicalblog.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public boolean loginUser(User user){
        if(user.getUsername().equals("validuser"))
            return true;
        return false;
    }
    public void registerUser(User user) {
        repository.registerUser(user);
    }

    public User login(User user) {
        return repository.checkUser(user.getUsername(),user.getPassword());
    }
}
