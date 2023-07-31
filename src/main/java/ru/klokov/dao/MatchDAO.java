package ru.klokov.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.klokov.exception.DatabaseException;
import ru.klokov.model.Match;
import ru.klokov.model.Page;
import ru.klokov.util.HibernateUtil;

import java.util.List;

public class MatchDAO implements IMatchDAO {
    @Override
    public Long findMatchesQuantity() {
        String hql = "Select count(*) from Match";

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(hql, Long.class).uniqueResult();
        } catch (HibernateException e) {
            throw new DatabaseException("Database error!");
        }
    }

    @Override
    public Long findMatchesQuantityByPlayerName(String name) {
        String hql = "Select count(*) from Match m where m.playerOne.name = :name or m.playerTwo.name = :name";

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(hql, Long.class).setParameter("name", name).uniqueResult();
        } catch (HibernateException e) {
            throw new DatabaseException("Database error!");
        }
    }

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
    public Page<Match> findAllPaginated(int pageNumber, int pageSize) {
        String hql = "From Match";
        int offset = (pageNumber - 1) * pageSize;
        List<Match> matches;
        Long totalElements;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            matches = session.createQuery(hql, Match.class)
                    .setFirstResult(offset)
                    .setMaxResults(pageSize)
                    .list();
            totalElements = findMatchesQuantity();
        } catch (HibernateException e) {
            throw new DatabaseException("Database error!");
        }

        Long totalPages = (totalElements % pageSize == 0) ? totalElements : totalElements / pageSize + 1;

        return new Page<>(matches, pageNumber, pageSize, totalPages, totalElements);
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
    public Page<Match> findByPlayerNamePaginated(int pageNumber, int pageSize, String name) {
        String hql = "From Match m where m.playerOne.name = :name or m.playerTwo.name = :name";
        int offset = (pageNumber - 1) * pageSize;
        List<Match> matches;
        Long totalElements;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            matches = session.createQuery(hql, Match.class)
                    .setParameter("name", name)
                    .setFirstResult(offset)
                    .setMaxResults(pageSize)
                    .list();
            totalElements = findMatchesQuantityByPlayerName(name);
        } catch (HibernateException e) {
            throw new DatabaseException("Database error!");
        }

        Long totalPages = (totalElements % pageSize == 0) ? totalElements : totalElements / pageSize + 1;

        return new Page<>(matches, pageNumber, pageSize, totalPages, totalElements);
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
