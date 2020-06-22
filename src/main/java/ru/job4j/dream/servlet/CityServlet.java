package ru.job4j.dream.servlet;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import ru.job4j.dream.model.City;
import ru.job4j.dream.store.PsqlStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Сервлет для вывода списка городов
 * @author Roman Yakimkin (r.yakimkin@yandex.ru)
 * @since 22.06.2020
 * @version 1.0
 */
public class CityServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        Map<String, String> citiesMap = new HashMap<>();
        for (City city : PsqlStore.instOf().findAllCities()) {
            citiesMap.put(String.valueOf(city.getId()), city.getName());
        }
        String jsonOutput = JSONObject.toJSONString(citiesMap);
        resp.getWriter().write(jsonOutput);
    }
}
