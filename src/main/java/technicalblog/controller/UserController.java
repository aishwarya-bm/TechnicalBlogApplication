package technicalblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import technicalblog.model.Post;
import technicalblog.model.User;
import technicalblog.service.PostService;
import technicalblog.service.UserService;

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
    public String register(){
        return "users/register";
    }

    @RequestMapping(value="users/login",method= RequestMethod.POST)
    public String loginuser(User user){
        if(userService.login(user))
            return "redirect:/posts";
        else
            return "users/login";
    }
    @RequestMapping(value="users/logout",method= RequestMethod.POST)
    public String logoutuser(Model model){
        List<Post> posts= postService.getAllPosts();
        model.addAttribute("posts",posts);
        return "index";
    }
    @RequestMapping(value="users/register",method= RequestMethod.POST)
    public String registeruser(User user){
        return "/users/login";
    }

}
