package ru.klokov.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import ru.klokov.exception.DatabaseException;
import ru.klokov.exception.ResourceNotFoundException;
import ru.klokov.model.Match;
import ru.klokov.model.Player;


import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Properties;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();

                Properties properties = new Properties();

                properties.put(Environment.DIALECT, "org.hibernate.dialect.H2Dialect");
                properties.put(Environment.DRIVER, "org.h2.Driver");
                properties.put(Environment.URL, "jdbc:h2:mem:tennis_scoreboard");
                properties.put(Environment.USER, "root");
                properties.put(Environment.PASS, "root");
                properties.put(Environment.HBM2DDL_AUTO, "create-drop");
                properties.put(Environment.SHOW_SQL, "true");
                properties.put(Environment.FORMAT_SQL, "true");

                configuration.setProperties(properties);

                configuration.addAnnotatedClass(Player.class);
                configuration.addAnnotatedClass(Match.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (HibernateException e) {
                throw new DatabaseException("Database error!");
            }
        }

        return sessionFactory;
    }

    public static void initDatabase() {
        String sql;
        try {
            sql = new String(Files.readAllBytes(Paths.get(Objects.requireNonNull(
                    HibernateUtil.class.getClassLoader().getResource("data.sql")).toURI())));
        } catch (IOException | URISyntaxException e) {
            throw new ResourceNotFoundException(e.getMessage());
        }
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.getTransaction().begin();
            session.createNativeQuery(sql, void.class).executeUpdate();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            throw new DatabaseException("Database error!");
        }
    }
}
