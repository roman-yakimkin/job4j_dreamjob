package ru.job4j.dream.servlet;

import org.junit.Test;
import ru.job4j.dream.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class IndexServletTest {

    private final static String path = "index.jsp";

    @Test
    public void whenIndexPageIsCalled() throws ServletException, IOException {
        IndexServlet servlet = new IndexServlet();
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        RequestDispatcher dispatcher = mock(RequestDispatcher.class);
        HttpSession session = mock(HttpSession.class);
        User user = mock(User.class);

        when(req.getSession()).thenReturn(session);
        when(session.getAttribute("user")).thenReturn(user);
        when(req.getRequestDispatcher(path)).thenReturn(dispatcher);
        servlet.doGet(req, resp);

        verify(req, times(1)).setAttribute("user", user);
        verify(req, times(1)).getRequestDispatcher(path);
        verify(dispatcher).forward(req, resp);
    }
}
