package ru.klokov.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.klokov.exception.DatabaseException;
import ru.klokov.model.Match;
import ru.klokov.util.HibernateUtil;

import java.util.List;

public class MatchDAO implements IMatchDAO {
    @Override
    public List<Match> findAll() {
        String hql = "From Match";

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(hql, Match.class).list();
        } catch (HibernateException e) {
            throw new DatabaseException("Database error!");
        }
    }

    @Override
    public List<Match> findByPlayerName(String name) {
        String hql = "From Match m where m.playerOne.name = :name or m.playerTwo.name = :name";

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(hql, Match.class).setParameter("name", name).list();
        } catch (HibernateException e) {
            throw new DatabaseException("Database error!");
        }
    }

    @Override
    public void save(Match match) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(match);
            transaction.commit();
        } catch (HibernateException e) {
            throw new DatabaseException("Database error!");
        }
    }
}
