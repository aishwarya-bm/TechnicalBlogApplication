package technicalblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import technicalblog.model.Post;
import technicalblog.model.User;
import technicalblog.model.UserProfile;
import technicalblog.service.PostService;
import technicalblog.service.UserService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private PostService postService;
    @Autowired
    private UserService userService;

    @RequestMapping("users/login")  // th:href="@{users/login}" in layout.html
    public String login(){
        return "users/login";
    }

    @RequestMapping("users/register")
    public String register(Model model){
        User user =new User();
        UserProfile profile = new UserProfile();
        user.setProfile(profile);
        model.addAttribute("User",user);
        return "users/register";
    }

    @RequestMapping(value="users/register",method= RequestMethod.POST)
    public String registeruser(User user){
        userService.registerUser(user);
        return "/users/login";
    }

    @RequestMapping(value="users/login",method= RequestMethod.POST)
    public String loginuser(User user, HttpSession session){
        User verifyUser = userService.login(user);
        session.setAttribute("loggedinuser",verifyUser);
        if(verifyUser != null)
            return "redirect:/posts";
        else
            return "users/login";
    }
    @RequestMapping(value="users/logout",method= RequestMethod.POST)
    public String logoutuser(Model model, HttpSession session){
        session.invalidate();
        List<Post> posts= postService.getAllPosts();
        model.addAttribute("posts",posts);
        return "index";
    }
}
