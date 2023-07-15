package ru.klokov.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.klokov.model.Match;
import ru.klokov.service.NewMatchService;
import ru.klokov.service.OnGoingMatchesService;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/new-match")
public class NewMatchServlet extends BaseServlet {
    private NewMatchService newMatchService;
    private OnGoingMatchesService onGoingMatchesService;

    @Override
    public void init(ServletConfig config) {
        newMatchService = (NewMatchService) config.getServletContext().getAttribute("newMatchService");
        onGoingMatchesService = (OnGoingMatchesService) config.getServletContext().getAttribute("onGoingMatchesService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/new-match.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String> errors = new HashMap<>();
        String playerOneName = req.getParameter("playerOneName");
        String playerTwoName = req.getParameter("playerTwoName");

        if (nameNotValid(playerOneName)) errors.put("playerOneNameNotValid", "Player 1 name should contain only letters!");
        if (nameNotValid(playerTwoName)) errors.put("playerTwoNameNotValid", "Player 2 name should contain only letters!");
        if (!playerOneName.isBlank() && playerOneName.equals(playerTwoName)) errors.put("playerNamesAreSame", "Player names can't be same!");

        if (errors.isEmpty()) {
            Match match = newMatchService.createNewMatch(playerOneName, playerTwoName);
            String uuid = onGoingMatchesService.add(match);
            resp.sendRedirect("match-score?uuid=" + uuid);
        } else {
            req.setAttribute("playerOneName", playerOneName);
            req.setAttribute("playerTwoName", playerTwoName);
            req.setAttribute("errors", errors);
            req.getRequestDispatcher("/new-match.jsp").forward(req, resp);
        }
    }

    private boolean nameNotValid(String name) {
        return name.isBlank() || !name.chars().allMatch(Character::isLetter);
    }
}
