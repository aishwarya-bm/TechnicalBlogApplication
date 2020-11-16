package technicalblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import technicalblog.model.Post;
import technicalblog.model.User;
import technicalblog.repository.PostRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PostService { // Addresses business logic or functional needs required for blog posts

    @Autowired
    private PostRepository repository;

    public List<Post> getAllPosts(){
        //hardcoded data
//       ArrayList<Post> posts = new ArrayList<>();
//        Post p1 = new Post();
//        p1.setTitle("Post 1");
//        p1.setBody("My first blog post");
//        p1.setDate(new Date());
//        Post p2 = new Post();
//        p2.setTitle("Post 2");
//        p2.setBody("second blog post");
//        p2.setDate(new Date());
//        Post p3 = new Post();
//        p3.setTitle("Post 3");
//        p3.setBody("Third blog post");
//        p3.setDate(new Date());
//        posts.add(p1);
//        posts.add(p2);
//        posts.add(p3);
     //jdbc approach
//        Connection connection = null;
//        try {
//            Class.forName("org.postgresql.Driver");
//             connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/technicalblog","postgres","postgres");
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery("SElECT * FROM posts");
//            while (resultSet.next())
//            {
//                Post p =new Post();
//                p.setTitle(resultSet.getString("title"));
//                p.setBody(resultSet.getString("body"));
//                posts.add(p);
//            }
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//        }
//        finally {
//            try {
//                connection.close();
//            } catch (SQLException throwables) {
//                throwables.printStackTrace();
//            }
//        }
        //jpa approach
//        @PersistenceUnit(unitName = "techblog")
//        private EntityManagerFactory emf;
//        EntityManager em = emf.createEntityManager();
//        TypedQuery query = em.createQuery("SELECT p FROM Post p",Post.class);
//        return query.getResultList();
        //approach to introduce repository layer(or DAO layer) between service and db layer
        return repository.getAllPosts();
    }

    public List<Post> getOnePost() {
//        ArrayList<Post> posts = new ArrayList<>();
//
//        Connection connection = null;
//        try {
//            Class.forName("org.postgresql.Driver");
//            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/technicalblog","postgres","postgres");
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery("SElECT * FROM posts WHERE id=1");
//            while (resultSet.next())
//            {
//                Post p =new Post();
//                p.setTitle(resultSet.getString("title"));
//                p.setBody(resultSet.getString("body"));
//                posts.add(p);
//            }
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//        }
//        finally {
//            try {
//                connection.close();
//            } catch (SQLException throwables) {
//                throwables.printStackTrace();
//            }
//        }
//        return posts;
        return repository.getAllPosts();
    }

    public void createPost (Post newPost){
        newPost.setDate(new Date());
        repository.createPost(newPost);
    }

    public Post getPost(Integer id)
    {
        return repository.getPost(id);
    }
    public void editPost(Post p) {
        p.setDate(new Date());
        repository.editPost(p);
    }

    public void deletePost(Post post) {
        repository.deletePost(post);
    }

    public void deletePost(Integer id) {
        repository.deletePost(id);
    }


}
