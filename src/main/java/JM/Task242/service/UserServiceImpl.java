package JM.Task242.service;

 /* версия 2.0 */

import JM.Task242.dao.UserDAO;
import JM.Task242.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService {

    private UserDAO userDao;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDao = userDAO;
    }


    @Override
    public List<User> allUsers() {
        return userDao.allUsers();
    }

    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public void delete(Long id) {
        userDao.delete(id);
    }

    @Override
    public void edit(User user) {
        userDao.edit(user);
    }

    @Override
    public User getById(Long id) {
        return userDao.getById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userDao.getUserByName(s);
    }
}
