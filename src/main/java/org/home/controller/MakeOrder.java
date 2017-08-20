package org.home.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MakeOrder", urlPatterns = {"/controller/makeOrder"})
public class MakeOrder extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/main.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int amount = (int) request.getSession().getAttribute("amount");

        if (amount > 0) {
            request.getRequestDispatcher("/jsp/makeOrder.jsp").forward(request, response);
        } else {
            request.setAttribute("cartError", "Ваша корзина пуста. Добавьте вкусняшек! :)");
            request.getRequestDispatcher("/jsp/cart.jsp").forward(request, response);
        }
    }
}
