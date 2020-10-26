package technicalblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import technicalblog.model.Post;

import java.util.ArrayList;
import java.util.Date;

@Service
public class PostService { // Addresses business logic or functional needs required for blog posts
    public ArrayList<Post> getAllPosts(){
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

        return posts;
    }

    public ArrayList<Post> getOnePost() {
        ArrayList<Post> posts = new ArrayList<>();

        Post post1 = new Post();
        post1.setTitle("This is your Post");
        post1.setBody("This is your Post. It has some valid content");
        post1.setDate(new Date());
        posts.add(post1);
        return posts;
    }

    public void createPost (Post newPost){
    }

}
