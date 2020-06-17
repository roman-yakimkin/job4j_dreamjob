package ru.job4j.dream.servlet;

import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.model.Photo;
import ru.job4j.dream.model.Post;
import ru.job4j.dream.store.PsqlStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

/**
 * Сервлет для удаления сущности
 * @author Roman Yakimkin (r.yakimkin@yandex.ru)
 * @since 17.06.2020
 * @version 1.0
 */
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String entityName = req.getParameter("entity");
        String id = req.getParameter("id");
        switch (entityName) {
            case "post" :
                req.setAttribute("posts", PsqlStore.instOf().findAllPosts());
                req.getRequestDispatcher("posts.jsp").forward(req, resp);
                break;
            case "candidate" :
                PsqlStore.instOf().removeCandidate(Integer.parseInt(id));
                req.setAttribute("candidates", PsqlStore.instOf().findAllCandidates());
                req.getRequestDispatcher("candidates.jsp").forward(req, resp);
                break;
            default:
                req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
    }
}
