package com.zetcode.service;

import com.zetcode.bean.User;
import com.zetcode.util.ServiceLocator;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class DatabaseService {

    public static User getUserById(Long id) {

        String sql = "SELECT * FROM Users WHERE Id = ?";

        JdbcTemplate jtm = getJDBCTempate();
        User user = (User) jtm.queryForObject(sql, new Object[]{id},
                new BeanPropertyRowMapper(User.class));

        return user;
    }
    
    public static void addUser(User user) {
        
        
        String sql = "INSERT INTO Users(Firstname, Lastname, Email) VALUES(?, ?, ?)";
        
        JdbcTemplate jtm = getJDBCTempate();
        jtm.update(sql, new Object[] {user.getFirstName(), 
            user.getLastName(), user.getEmail()});
    }
    
    public static void deleteUser(Long id) {
        
        String sql = "DELETE From Users WHERE Id = ?";
        
        JdbcTemplate jtm = getJDBCTempate();
        jtm.update(sql, new Object[] {id});
    }
    
    public static void updateUser(User user) {
        
        String sql = "UPDATE Users SET Firstname=?, Lastname=?, Email=? WHERE Id=?";
        
        JdbcTemplate jtm = getJDBCTempate();
        jtm.update(sql, new Object[] {user.getFirstName(), 
            user.getLastName(), user.getEmail(), user.getId()});
        
    }

    public static List<User> getAllUsers() {

        String sql = "SELECT * FROM Users";

        JdbcTemplate jtm = getJDBCTempate();
        
        List<User> users = (List<User>) jtm.query(sql,
                new BeanPropertyRowMapper(User.class));
        
        return users;
    }
    
    private static JdbcTemplate getJDBCTempate() {
        
        DataSource ds = ServiceLocator.getDataSource("java:comp/env/jdbc/testdb");
        JdbcTemplate jtm = new JdbcTemplate(ds);
        
        return jtm;
    }
}
