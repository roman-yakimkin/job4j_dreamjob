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
 * Сервлет для редактирования сущности
 * @author Roman Yakimkin (r.yakimkin@yandex.ru)
 * @since 16.06.2020
 * @version 1.0
 */
public class EditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String entityName = req.getParameter("entity");
        String id = req.getParameter("id");
        String params = req.getParameter("id") != null ? "?id=" + req.getParameter("id") : "";
        switch (entityName) {
            case "post" :
                Post post = new Post(0, "");
                if (req.getParameter("id") != null) {
                    req.setAttribute("id", id);
                    post = PsqlStore.instOf().findPostById(Integer.valueOf(id));
                }
                req.setAttribute("post", post);
                req.getRequestDispatcher("post/edit.jsp" + params).forward(req, resp);
                break;
            case "candidate" :
                Candidate candidate = new Candidate(0, "", 0);
                Collection<Photo> photos = PsqlStore.instOf().findAllPhotos();
                if (req.getParameter("id") != null) {
                    req.setAttribute("id", id);
                    candidate = PsqlStore.instOf().findCandidateById(Integer.valueOf(id));
                }
                req.setAttribute("candidate", candidate);
                req.setAttribute("photos", photos);
                req.getRequestDispatcher("candidate/edit.jsp" + params).forward(req, resp);
                break;
            default:
                req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
    }
}
