package apap.tutorial.cineplux.controller;

import apap.tutorial.cineplux.model.BioskopModel;
import apap.tutorial.cineplux.model.PenjagaModel;
import apap.tutorial.cineplux.model.RoleModel;
import apap.tutorial.cineplux.model.UserModel;
import apap.tutorial.cineplux.service.RoleService;
import apap.tutorial.cineplux.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @GetMapping("/add")
    private String addUserFormPage(Model model){
        UserModel user = new UserModel();
        List<RoleModel> listRole = roleService.getListRole();
        model.addAttribute("user", user);
        model.addAttribute("listRole", listRole);
        return "form-add-user";
    }

    @PostMapping(value="/add")
    private String addUserSubmit(@ModelAttribute UserModel user, Model model){
        userService.addUser(user);
        model.addAttribute("user", user);
        return "redirect:/";
    }

    @GetMapping("/viewall")
    private String listUsers(Model model) {
        // Mendapatkan semua users
        List<UserModel> listUser = userService.getListUser();

        // Add variable semua UserModel ke 'listUser' untuk dirender dalam thymeleaf
        model.addAttribute("listUser", listUser);

        // Return view template yang diinginkan
        return "viewall-user";
    }

    @GetMapping("/delete/{username}")
    public String deleteUser(
            @PathVariable String username,
            Model model
    ){
        UserModel user = userService.getUserByUsername(username);
        model.addAttribute("user", user);
        model.addAttribute("username", username);

        userService.deleteUser(user);
        return "delete-user";
    }

    @GetMapping("/change-password")
    private String changePasswordForm(Model model){
        UserModel user = new UserModel();
        model.addAttribute("user", user);
        return "form-change-password";
    }

    @PostMapping(value="/change-password")
    private String changePasswordSubmit(@RequestParam(value = "passwordLama") String passwordLama,
                                        @RequestParam(value = "passwordBaru") String passwordBaru,
                                        @RequestParam(value = "passwordKonfir") String passwordKonfir, Model model){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetail = (UserDetails) auth.getPrincipal();
        UserModel user = userService.getUserByUsername(userDetail.getUsername());

        String existingPassword = passwordLama;
        String dbPassword = user.getPassword();

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if (passwordEncoder.matches(existingPassword, dbPassword) && passwordKonfir.equals(passwordBaru)) {
            userService.ubahPassword(user,passwordEncoder.encode(passwordBaru));
        } else {
            return "error-change";
        }
//        model.addAttribute("validation", userService.password(passwordBaru));
        model.addAttribute("user", user);
        return "redirect:/";
    }

}
