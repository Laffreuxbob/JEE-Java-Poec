package fr.epsi.rennes.poec.bob.dao;

import fr.epsi.rennes.poec.bob.domain.Article;
import fr.epsi.rennes.poec.bob.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDAO {

    @Autowired
    private DataSource ds;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User getUserByEmail(String mail) throws SQLException {
        List<Article> list = new ArrayList<>();

        String sqlSelect = "Select email, password FROM users WHERE email ='" + mail + "'";
        Statement stmt = ds.getConnection().createStatement();
        ResultSet rs = stmt.executeQuery(sqlSelect);

        if (rs.next()){
            User user = new User();
            user.setEmail(rs.getString(1));
            user.setPassword(rs.getString(2));
            return user;
        }else{
            return null;
        }
    }

    public void addUser(User user) throws SQLException {
        String password = passwordEncoder.encode(user.getPassword());

        String sql = "INSERT INTO users (email, password) VALUES ('" +
                user.getEmail() + "', '" + password + "');";

        Statement stmt = ds.getConnection().createStatement();
        stmt.executeUpdate(sql);
    }
}
