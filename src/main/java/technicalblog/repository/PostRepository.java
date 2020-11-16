package technicalblog.repository;

import org.springframework.stereotype.Repository;
import technicalblog.model.Post;
import technicalblog.model.User;

import javax.persistence.*;
import java.util.List;

@Repository
public class PostRepository {

    @PersistenceUnit(name = "techblog")
    private EntityManagerFactory emf;
    public List<Post> getAllPosts()
    {
        EntityManager em = emf.createEntityManager();
        TypedQuery query = em.createQuery("select p from Post p",Post.class);
        return query.getResultList();
    }

    public Post getLatestPost()
    {
        EntityManager em = emf.createEntityManager();
        return em.find(Post.class,3);
    }

    public Post createPost(Post p)
    {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try
        {
            transaction.begin();
            em.persist(p);
            transaction.commit();
        }
        catch (Exception e)
        {
            transaction.rollback();
        }
        return p;// p is returned again because only after persist statement id(PK) is generated, until then id is not generated
    }
    public Post getPost(Integer id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Post.class,id);
    }
    public void editPost(Post p) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try
        {
            transaction.begin();
            em.merge(p);
            transaction.commit();
        }
        catch (Exception e)
        {
            transaction.rollback();
        }
    }


    public void deletePost(Post post) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try
        {
            transaction.begin();
            Post p = em.find(Post.class,post.getId());
            em.remove(p);
            transaction.commit();
        }
        catch (Exception e)
        {
            transaction.rollback();
        }
    }

    public void deletePost(Integer id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try
        {
            transaction.begin();
            Post p = em.find(Post.class,id);
            em.remove(p);
            transaction.commit();
        }
        catch (Exception e)
        {
            transaction.rollback();
        }
    }


}
