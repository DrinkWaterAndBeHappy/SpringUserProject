package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager em;

    /*
        private final List<User> fullListUser = List.of(
                new User("Ivan", "Ivanov", "ivanov@mail"),
                new User("Georgy", "Georgyev", "georg@mail"),
                new User("Pavel", "Pavlov", "pav@mail"),
                new User("Oleg", "Olegov", "oleg@mail"),
                new User("Igor", "Igorev", "igor@mail"),
                new User("Alex", "Alexov", "alex@mail")
        );
        @Override
        public void addUser(User user) {
            em.persist(user);
        }

        @Override
        public List<User> getUsers() {
            return fullListUser;
        }
     */
    @Override
    public void addUser(User user) {
        em.persist(user);
    }

    @Override
    public List<User> getUsers() {
        return em.createQuery("FROM User", User.class).getResultList();
    }

    @Override
    public void deleteUserVyId(long id) {
        User user = em.find(User.class, id);
        if(user != null) {
            em.remove(user);
            em.flush();
        }
    }

    @Override
    public void updateUser(User user) {
        em.merge(user);
    }

    @Override
    public User getUserById(long id) {
        return em.find(User.class, id);
    }
}

