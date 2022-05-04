package fr.epsi.rennes.poec.bob;

import fr.epsi.rennes.poec.bob.dao.ArticleDAO;
import fr.epsi.rennes.poec.bob.domain.Article;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication(scanBasePackages = "fr.epsi.rennes.poec.bob")
public class JEEApplication {

    public static void main(String[] args) throws SQLException {
        System.out.println("test");
        SpringApplication.run(JEEApplication.class, args);


    }
}
