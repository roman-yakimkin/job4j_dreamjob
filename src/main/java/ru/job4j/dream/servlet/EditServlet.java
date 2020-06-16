package ru.job4j.dream.servlet;

import ru.job4j.dream.store.Store;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Сервлет для редактирования сущности
 * @author Roman Yakimkin (r.yakimkin@yandex.ru)
 * @since 16.06.2020
 * @version 1.0
 */
public class EditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String entityName = req.getParameter("entity");
        String params = req.getParameter("id") != null ? "?id=" + req.getParameter("id") : "";
        switch (entityName) {
            case "post" :
                req.getRequestDispatcher("post/edit.jsp" + params).forward(req, resp);
                break;
            case "candidate" :
                req.getRequestDispatcher("candidate/edit.jsp" + params).forward(req, resp);
                break;
            default:
                req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
    }
}
