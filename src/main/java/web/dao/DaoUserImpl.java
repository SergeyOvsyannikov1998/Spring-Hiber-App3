package web.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import java.util.List;

@Repository
public class DaoUserImpl implements DaoUser {
    private static final Logger log = LoggerFactory.getLogger(DaoUserImpl.class);
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(user);
        log.info("Add user: " + user);

    }

    @Override
    public void updateUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.update(user);
        log.info("Update user: " + user);
    }

    @Override
    public void removeUser(int id) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.load(User.class, new Integer(id));
        if (user != null) {
            session.delete(user);
            log.info("Delete user: " + user);
        }
        log.info("User is null: " + user);

    }

    @Override
    public User getUserById(int id) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.load(User.class, new Integer(id));
        log.info("User is loaded: " + user);
        return user;
    }

    @Override
    public List<User> listUser() {
        Session session = sessionFactory.getCurrentSession();
        List<User> list = session.createQuery("from User ").list();
        for (User user : list) {
            log.info("User list: " + user);
        }
        return list;
    }
}
