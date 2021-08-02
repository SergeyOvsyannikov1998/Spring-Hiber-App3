package web.service;

import org.springframework.stereotype.Service;
import web.dao.DaoUser;
import web.model.User;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final DaoUser daoUser;

    public UserServiceImpl(DaoUser daoUser) {
        this.daoUser = daoUser;
    }

    @Transactional
    @Override
    public void addUser(User user) {
        this.daoUser.addUser(user);

    }

    @Transactional
    @Override
    public void updateUser(User user) {
        this.daoUser.updateUser(user);
    }

    @Transactional
    @Override
    public void removeUser(int id) {
        this.daoUser.removeUser(id);
    }

    @Transactional
    @Override
    public User getUserById(int id) {
        return this.daoUser.getUserById(id);
    }

    @Transactional
    @Override
    public List<User> listUser() {
        return this.daoUser.listUser();
    }
}
