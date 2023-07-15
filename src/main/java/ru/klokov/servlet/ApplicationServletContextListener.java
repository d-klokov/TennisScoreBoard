package ru.klokov.servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import ru.klokov.dao.IMatchDAO;
import ru.klokov.dao.IPlayerDAO;
import ru.klokov.dao.MatchDAO;
import ru.klokov.dao.PlayerDAO;
import ru.klokov.exception.DatabaseException;
import ru.klokov.service.FinishedMatchesPersistenceService;
import ru.klokov.service.MatchScoreCalculationService;
import ru.klokov.service.NewMatchService;
import ru.klokov.service.OnGoingMatchesService;
import ru.klokov.util.HibernateUtil;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

@WebListener
public class ApplicationServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();

        HibernateUtil.initDatabase();

        IPlayerDAO playerDAO = new PlayerDAO();
        IMatchDAO matchDAO = new MatchDAO();

        context.setAttribute("matchDAO", matchDAO);
        context.setAttribute("newMatchService", new NewMatchService(playerDAO));
        context.setAttribute("onGoingMatchesService", new OnGoingMatchesService());
        context.setAttribute("matchScoreCalculationService", new MatchScoreCalculationService());
        context.setAttribute("finishedMatchesPersistenceService", new FinishedMatchesPersistenceService(matchDAO));
    }
}
