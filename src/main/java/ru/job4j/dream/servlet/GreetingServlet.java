package ru.job4j.dream.servlet;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Map;

/**
 * Сервлет для отправки приветствия
 * @author Roman Yakimkin (r.yakimkin@yandex.ru)
 * @since 21.06.2020
 * @version 1.0
 */
public class GreetingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        writer.println("Nice to meet you, " + name);
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JSONParser jsonParser = new JSONParser();
        try {
            JSONObject jsonObject = (JSONObject) jsonParser.parse(req.getReader());
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            String name = jsonObject.get("name").toString();
            String jsonOutput = JSONObject.toJSONString(Map.of("name", "Nice to meet you, " + name));
            resp.getWriter().write(jsonOutput);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
