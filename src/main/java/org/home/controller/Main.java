package org.home.controller;

import org.home.model.entity.Dish;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "Main", urlPatterns = {"/controller/main"})
public class Main extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doAction(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doAction(request, response);
    }

    private void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        if (session.getAttribute("cart") == null) {
            Map<Dish, Integer> cart = new HashMap<>();
            session.setAttribute("cart", cart);
        }

        if (session.getAttribute("amount") == null) {
            session.setAttribute("amount", 0);
        }

        request.getRequestDispatcher("/jsp/main.jsp").forward(request, response);
    }
}
