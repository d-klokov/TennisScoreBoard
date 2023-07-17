package ru.klokov.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.klokov.exception.BadRequestException;
import ru.klokov.exception.ResourceNotFoundException;
import ru.klokov.model.EPlayer;
import ru.klokov.model.Match;
import ru.klokov.service.FinishedMatchesPersistenceService;
import ru.klokov.service.MatchScoreCalculationService;
import ru.klokov.service.OnGoingMatchesService;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/match-score")
public class MatchScoreServlet extends BaseServlet {
    private OnGoingMatchesService onGoingMatchesService;
    private MatchScoreCalculationService matchScoreCalculationService;
    private FinishedMatchesPersistenceService finishedMatchesPersistenceService;

    @Override
    public void init(ServletConfig config) {
        onGoingMatchesService = (OnGoingMatchesService) config.getServletContext()
                .getAttribute("onGoingMatchesService");
        matchScoreCalculationService = (MatchScoreCalculationService) config.getServletContext()
                .getAttribute("matchScoreCalculationService");
        finishedMatchesPersistenceService = (FinishedMatchesPersistenceService) config.getServletContext()
                .getAttribute("finishedMatchesPersistenceService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uuid = req.getParameter("uuid");

        if (uuid.isBlank()) throw new BadRequestException("UUID of match doesn't present in request!");

        req.setAttribute("uuid", uuid);

        Optional<Match> matchOpt = onGoingMatchesService.get(uuid);
        if (matchOpt.isEmpty()) throw new ResourceNotFoundException("Match with UUID " + uuid + " not found!");

        Match match = matchOpt.get();
        req.setAttribute("match", match);
        req.setAttribute("isTieBreak", matchScoreCalculationService.isTieBreak(match.getMatchScore()));

        req.getRequestDispatcher("/match-score.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uuid = req.getParameter("uuid");
        if (uuid.isBlank()) throw new BadRequestException("UUID of match doesn't present in request!");

        Optional<Match> matchOpt = onGoingMatchesService.get(uuid);
        if (matchOpt.isEmpty()) throw new ResourceNotFoundException("Match with UUID " + uuid + " not found!");

        Match match = matchOpt.get();

        String playerNumberParameter = req.getParameter("playerNumberParameter");
        if (playerNumberParameter.isBlank()) throw new BadRequestException("UUID of match doesn't present in request!");

        EPlayer playerNumber = Integer.parseInt(playerNumberParameter) == 0 ? EPlayer.PLAYER_ONE : EPlayer.PLAYER_TWO;

        boolean matchFinished = matchScoreCalculationService.playerWinsPoint(playerNumber, match.getMatchScore());

        if (matchFinished) {
            match.setWinner(matchScoreCalculationService.getWinner(match.getMatchScore()).equals(EPlayer.PLAYER_ONE) ?
                    match.getPlayerOne() : match.getPlayerTwo());

            finishedMatchesPersistenceService.save(match);
            onGoingMatchesService.remove(uuid);

            req.setAttribute("uuid", uuid);
            req.setAttribute("match", match);

            req.getRequestDispatcher("/final-score.jsp").forward(req, resp);
            return;
        }

        resp.sendRedirect("match-score?uuid=" + uuid);
    }
}
