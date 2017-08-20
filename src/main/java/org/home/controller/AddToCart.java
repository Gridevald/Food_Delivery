package org.home.controller;

import org.home.model.entity.Dish;
import org.home.model.handler.DishHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "AddToCart", urlPatterns = {"/controller/addToCart"})
public class AddToCart extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/main.jsp").forward(request, response);
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Map<Dish, Integer> cart = (Map<Dish, Integer>) request.getSession().getAttribute("cart");
        String dishName = request.getParameter("dishName");
        int amount = (int) request.getSession().getAttribute("amount");

        Dish temp = DishHandler.findDish(dishName);

        if (cart.containsKey(temp)) {
            cart.put(temp, cart.get(temp) + 1);
        } else {
            cart.put(temp, 1);
        }

        amount++;

        request.getSession().setAttribute("cart", cart);
        request.getSession().setAttribute("amount", amount);
        request.getRequestDispatcher("/jsp/menu.jsp").forward(request, response);
    }
}
