package apap.tutorial.cineplux.service;

import apap.tutorial.cineplux.model.BioskopModel;
import apap.tutorial.cineplux.model.FilmModel;
import apap.tutorial.cineplux.model.UserModel;

import java.util.List;

public interface UserService {
    UserModel addUser(UserModel user);
    String encrypt(String password);
    List<UserModel> getListUser();
    void deleteUser(UserModel user);
    UserModel getUserByUsername(String username);
    void ubahPassword(UserModel user, String newPassword);
//    boolean password(String password);
}
