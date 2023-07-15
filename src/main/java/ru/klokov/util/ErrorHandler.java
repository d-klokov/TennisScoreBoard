package ru.klokov.util;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ErrorHandler {
    public static void sendError(HttpServletRequest req, int code, String message) {
        String statusTitle = null;
        switch (code) {
            case HttpServletResponse.SC_INTERNAL_SERVER_ERROR:
                statusTitle = "Internal server error";
                break;
            case HttpServletResponse.SC_BAD_REQUEST:
                statusTitle = "Bad request";
                break;
            case HttpServletResponse.SC_NOT_FOUND:
                statusTitle = "Not found";
                break;
        }
        req.setAttribute("status", code);
        req.setAttribute("statusTitle", statusTitle);
        req.setAttribute("message", message);
        throw new RuntimeException();
    }
}
