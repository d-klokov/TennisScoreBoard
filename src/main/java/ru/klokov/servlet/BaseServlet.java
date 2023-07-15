package ru.klokov.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.HibernateException;
import ru.klokov.exception.BadRequestException;
import ru.klokov.exception.DatabaseException;
import ru.klokov.exception.ResourceNotFoundException;
import ru.klokov.util.ErrorHandler;

import java.io.IOException;
import java.net.URISyntaxException;

public class BaseServlet extends HttpServlet {
    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            super.service(req, res);
        } catch (DatabaseException | IOException e) {
            ErrorHandler.sendError(req, HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
        } catch (BadRequestException e) {
            ErrorHandler.sendError(req, HttpServletResponse.SC_BAD_REQUEST, e.getMessage());
        } catch (ResourceNotFoundException e) {
            ErrorHandler.sendError(req, HttpServletResponse.SC_NOT_FOUND, e.getMessage());
        }
    }
}
