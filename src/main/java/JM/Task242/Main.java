package JM.Task242;

import JM.Task242.dao.UserDAOImpl;
import JM.Task242.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/task242?serverTimezone=Europe/Moscow&useSSL=false";
        String username = "root";
        String password = "12345iB";
        System.out.println("Connecting...");

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connection successful!");
        } catch (SQLException e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
        }

//        UserDAOImpl userDAO = new UserDAOImpl();
//        userDAO.delete(1);
//
//       // users.forEach(user -> System.out.println(user.getFirstName()));

    }
}
