package org.home.controller;

import org.home.model.entity.Dish;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;

@WebServlet(name = "Cart", urlPatterns = {"/controller/cart"})
public class Cart extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/main.jsp").forward(request, response);
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Map<Dish, Integer> cart = (Map<Dish, Integer>) request.getSession().getAttribute("cart");
        double sum = 0;

        if (cart != null) {
            for (Map.Entry<Dish, Integer> entry : cart.entrySet()) {
                sum += entry.getKey().getPrice() * entry.getValue();
            }

            sum = new BigDecimal(sum).setScale(2, BigDecimal.ROUND_HALF_EVEN).doubleValue();

            request.getSession().setAttribute("sum", sum);
            request.getRequestDispatcher("/jsp/cart.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/jsp/main.jsp").forward(request, response);
        }
    }
}
