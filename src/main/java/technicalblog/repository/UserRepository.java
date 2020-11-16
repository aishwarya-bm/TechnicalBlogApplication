package technicalblog.repository;

import org.springframework.stereotype.Repository;
import technicalblog.model.User;

import javax.persistence.*;
@Repository
public class UserRepository {

    @PersistenceUnit(name = "techblog")
    private EntityManagerFactory emf;

    public User registerUser(User user) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try
        {
            transaction.begin();
            em.persist(user);
            transaction.commit();
        }
        catch (Exception e)
        {
            transaction.rollback();
        }
        return user;
    }

    public User checkUser(String username,String password) {
        try
        {
            EntityManager em = emf.createEntityManager();
            TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.username = :username AND u.password = :password", User.class);
            query.setParameter("username", username);
            query.setParameter("password", password);
            return query.getSingleResult();
        }
        catch (NoResultException nre)
        {
            return null;
        }
    }
}
