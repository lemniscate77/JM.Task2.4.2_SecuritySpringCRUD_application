package JM.Task242.dao;

import JM.Task242.model.User;

import java.util.List;


public interface UserDAO {
    List<User> allUsers();
    void add(User user);
    void delete(Long id);
    void edit(User user);
    User getById(Long id);
    User getUserByName(String name);
}
