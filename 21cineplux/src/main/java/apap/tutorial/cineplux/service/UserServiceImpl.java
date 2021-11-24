package apap.tutorial.cineplux.service;

import apap.tutorial.cineplux.model.BioskopModel;
import apap.tutorial.cineplux.model.FilmModel;
import apap.tutorial.cineplux.model.UserModel;
import apap.tutorial.cineplux.repository.UserDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

@Service
@Transactional
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDb userDb;

    @Override
    public UserModel addUser(UserModel user){
        String pass = encrypt(user.getPassword());
        user.setPassword(pass);
        return userDb.save(user);
    }

    @Override
    public String encrypt(String password){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        return hashedPassword;
    }

    @Override
    public List<UserModel> getListUser() {
        return userDb.findAll();
    }

    @Override
    public void deleteUser(UserModel user){
        userDb.delete(user);
    }

    @Override
    public UserModel getUserByUsername(String username){
        UserModel user = userDb.findByUsername(username);
        if (user!=null){
            return user;
        }
        return null;
    }

    @Override
    public void ubahPassword(UserModel user, String newPassword){
        user.setPassword(newPassword);
    }

//    @Override
//    public boolean password(String password){
//        boolean flag = true;
//
//        Pattern specialCharPatten = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
//        Pattern UpperCasePatten = Pattern.compile("[A-Z ]");
//        Pattern lowerCasePatten = Pattern.compile("[a-z ]");
//        Pattern digitCasePatten = Pattern.compile("[0-9 ]");
//        if (password.length() < 8) {
//            flag=false;
//        }
//        if (!specialCharPatten.matcher(password).find()) {
//            flag=false;
//        }
//        if (!UpperCasePatten.matcher(password).find()) {
//            flag=false;
//        }
//        if (!lowerCasePatten.matcher(password).find()) {
//            flag=false;
//        }
//        if (!digitCasePatten.matcher(password).find()) {
//            flag=false;
//        }
//
//        return flag;
//    }
}
