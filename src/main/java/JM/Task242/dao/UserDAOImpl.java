package JM.Task242.dao;

import JM.Task242.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
// тестирую гит
@Repository
public class UserDAOImpl implements UserDAO {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<User> allUsers() {
        List<User> allUsers = em.createQuery("from User ", User.class)
                .getResultList();
        return allUsers;
    }

    @Override
    public void add(User user) {
        em.persist(user);
    }

    @Override
    public void delete(Long id) {
        User user = em.find(User.class,id);
        em.remove(user);
    }

    @Override
    public void edit(User user) {
        em.merge(user);
    }

    @Override
    public User getById(Long id) {
        return em.find(User.class,id);
    }

    @Override
    public User getUserByName(String name) {
        return em.find(User.class,name);
    }

}
