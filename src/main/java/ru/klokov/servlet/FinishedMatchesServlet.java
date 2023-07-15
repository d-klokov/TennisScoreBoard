package ru.klokov.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.klokov.exception.BadRequestException;
import ru.klokov.model.Match;
import ru.klokov.service.FinishedMatchesPersistenceService;

import java.io.IOException;
import java.util.List;

@WebServlet("/matches")
public class FinishedMatchesServlet extends BaseServlet {
    private FinishedMatchesPersistenceService finishedMatchesPersistenceService;
    private static final int MATCHES_ON_PAGE = 3;

    @Override
    public void init(ServletConfig config) throws ServletException {
        finishedMatchesPersistenceService = (FinishedMatchesPersistenceService) config.getServletContext()
                .getAttribute("finishedMatchesPersistenceService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pageParameter = req.getParameter("page");
        int pageNumber = 1;

        if (pageParameter != null && !pageParameter.isBlank()) {
            try {
                pageNumber = Integer.parseInt(pageParameter);
            } catch (NumberFormatException e) {
                throw new BadRequestException("Page parameter must be a number!");
            }
        }

        String playerName = req.getParameter("filter_by_player_name");
        req.setAttribute("playerName", playerName);

        if (nameNotValid(playerName)) {
            String message = "Player name should contain only letters!";
            req.setAttribute("error", message);
            req.getRequestDispatcher("/finished-matches.jsp").forward(req, resp);
            return;
        }

        List<Match> matches = finishedMatchesPersistenceService.getFinishedMatches(playerName);

        int matchesQuantity = matches.size();
        int totalPages = (matchesQuantity % MATCHES_ON_PAGE == 0) ? matchesQuantity / MATCHES_ON_PAGE :
                matchesQuantity / MATCHES_ON_PAGE + 1;

        if (totalPages > 1) {
            int fromIndex = (pageNumber - 1) * MATCHES_ON_PAGE;
            int toIndex = (matchesQuantity < (fromIndex + MATCHES_ON_PAGE)) ?
                    fromIndex + (matchesQuantity - fromIndex) : fromIndex + MATCHES_ON_PAGE;
            List<Match> matchesPage = matches.subList(fromIndex, toIndex);
            req.setAttribute("matches", matchesPage);
        } else req.setAttribute("matches", matches);

        req.setAttribute("pageNumber", pageNumber);
        req.setAttribute("totalPages", totalPages);

        req.getRequestDispatcher("/finished-matches.jsp").forward(req, resp);
    }

    private boolean nameNotValid(String name) {
        return name != null && !name.isBlank() && !name.chars().allMatch(Character::isLetter);
    }
}
