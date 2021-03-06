package ru.job4j.dream.servlet;

import ru.job4j.dream.model.Post;
import ru.job4j.dream.store.PsqlStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Сервлет для сохранения вакансии
 * @author Roman Yakimkin (r.yakimkin@yandex.ru)
 * @version 1.0
 * @since 15.06.2020
 */
public class PostServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("user", req.getSession().getAttribute("user"));
        req.setAttribute("posts", PsqlStore.instOf().findAllPosts());
        req.getRequestDispatcher("posts.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        PsqlStore.instOf().savePost(
                new Post(Integer.valueOf(req.getParameter("id")), req.getParameter("name"))
        );
        resp.sendRedirect(req.getContextPath() + "/posts.do");
    }
}
