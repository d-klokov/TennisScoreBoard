package ru.klokov.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.klokov.exception.DatabaseException;
import ru.klokov.model.Player;
import ru.klokov.util.HibernateUtil;

import java.util.Optional;

public class PlayerDAO implements IPlayerDAO {
    @Override
    public Player findByName(String name) {
        String hql = "From Player where name = :name";

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(hql, Player.class).setParameter("name", name).uniqueResult();
        } catch (HibernateException e) {
            throw new DatabaseException("Database error!");
        }
    }

    @Override
    public void save(Player player) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(player);
            transaction.commit();
        } catch (HibernateException e) {
            throw new DatabaseException("Database error!");
        }
    }
}
