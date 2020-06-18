package ru.job4j.dream.servlet;

import ru.job4j.dream.model.User;
import ru.job4j.dream.store.PsqlStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Сервлет для регистрации пользователя
 * @author Roman Yakimkin (r.yakimkin@yandex.ru)
 * @since 18.06.2020
 * @version 1.0
 */
public class RegServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("user/reg.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        User userWithTheSameEmail = PsqlStore.instOf().findUser(req.getParameter("email"));
        if (userWithTheSameEmail != null) {
            req.setAttribute("message", "Пользователь с таким e-mail уже существует в системе");
            doGet(req, resp);
        } else {
            PsqlStore.instOf().saveUser(
              new User(0, req.getParameter("name"), req.getParameter("email"), req.getParameter("password"))
            );
            resp.sendRedirect(req.getContextPath() + "/posts.do");
        }
    }
}
