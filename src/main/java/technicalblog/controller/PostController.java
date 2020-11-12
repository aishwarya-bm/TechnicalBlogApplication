package technicalblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import technicalblog.model.Post;
import technicalblog.service.PostService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @RequestMapping("posts")
    public String getUserPosts(Model model) {
        List<Post> posts = postService.getAllPosts();
        //Post p = postService.getOnePost();
        //posts.add(p);
        model.addAttribute("posts", posts);
        return "posts";
    }
    @RequestMapping("/posts/newpost")
    public String newPost() {
        return "post/createpost";
    }

    @RequestMapping(value = "/posts/create", method = RequestMethod.POST)
    public String createPost(Post newPost) {
        postService.createPost(newPost);
        return "redirect:/posts";
    }

    @RequestMapping(value = "/editpost",method = RequestMethod.GET)
    public String editPost(@RequestParam(name="postId") Integer id, Model model)
    {
        Post post = postService.getPost(id);
        model.addAttribute("post",post);
        return "post/editpost";
    }

    @RequestMapping(value = "/editpost",method = RequestMethod.PUT)
    public String editPostSubmit(@RequestParam(name="postId") Integer id, Post post)
    {
        post.setId(id);
        postService.editPost(post);
        return "redirect:/posts";
    }
    @RequestMapping(value = "/deletepost", method = RequestMethod.GET)
    public String deletePost(@RequestParam(name = "postId") Integer id,Model model)
    {
        Post post = postService.getPost(id);
        model.addAttribute("post",post);
        return "post/deletepost";
    }
    @RequestMapping(value = "/deletepost", method = RequestMethod.DELETE)
    public String deletePostSubmit(@RequestParam(name = "postId") Integer id,Post post)
    {
        post.setId(id);
        postService.deletePost(post);
        return "redirect:/posts";
    }
    @RequestMapping(value = "/deletepostdirectly", method = RequestMethod.DELETE) // addtional implementation for delete
    public String deletePostDirectly(@RequestParam(name = "postId") Integer id)
    {
        postService.deletePost(id);
        return "redirect:/posts";
    }

}
