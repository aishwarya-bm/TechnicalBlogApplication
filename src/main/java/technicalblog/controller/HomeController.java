package technicalblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import technicalblog.model.Post;

import java.util.ArrayList;
import java.util.Date;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String getAllPosts(Model model) { // This is Spring provided Model class which helps in passing data from controller to view
        ArrayList<Post> posts = new ArrayList<>();
        Post p1 = new Post();
        p1.setTitle("Post 1");
        p1.setBody("My first blog post");
        p1.setDate(new Date());
        Post p2 = new Post();
        p2.setTitle("Post 2");
        p2.setBody("second blog post");
        p2.setDate(new Date());
        Post p3 = new Post();
        p3.setTitle("Post 3");
        p3.setBody("Third blog post");
        p3.setDate(new Date());

        posts.add(p1);
        posts.add(p2);
        posts.add(p3);

        model.addAttribute("posts", posts);
        return "index";
    }
}
