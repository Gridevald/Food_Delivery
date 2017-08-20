package org.home.controller;

import org.home.model.entity.Dish;
import org.home.model.handler.OrderHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(name = "Final", urlPatterns = {"/controller/final"})
public class Final extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/main.jsp").forward(request, response);
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String number = request.getParameter("number");

        if (name.trim().length() == 0 || address.trim().length() == 0 || number.trim().length() == 0) {
            request.setAttribute("orderError", "Все поля должны быть заполненными!");
            request.setAttribute("name", name);
            request.setAttribute("address", address);
            request.setAttribute("number", number);
            request.getRequestDispatcher("/jsp/makeOrder.jsp").forward(request, response);
            return;
        }

        Matcher m = Pattern.compile("\\+375-(25|29|33|44)-\\d{3}-\\d{2}-\\d{2}").matcher(number.trim());
        if (!m.matches()) {
            request.setAttribute("orderError", "Введите номер по примеру: +375-ХХ-ХХХ-ХХ-ХХ. возможный код: 25, 29, 33, 44.");
            request.setAttribute("name", name);
            request.setAttribute("address", address);
            request.setAttribute("number", number);
            request.getRequestDispatcher("/jsp/makeOrder.jsp").forward(request, response);
            return;
        }

        Map<String, String> customerData = new HashMap<>();
        customerData.put("name", name.trim());
        customerData.put("address", address.trim());
        customerData.put("number", number.trim());

        Map<Dish, Integer> dishData = (Map<Dish, Integer>) request.getSession().getAttribute("cart");

        OrderHandler.addOrder(dishData, customerData);

        request.getSession().setAttribute("cart", new HashMap<Dish, Integer>());
        request.getSession().setAttribute("amount", 0);
        request.getRequestDispatcher("/jsp/final.jsp").forward(request, response);
    }
}
