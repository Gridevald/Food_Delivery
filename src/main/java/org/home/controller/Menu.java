package org.home.controller;

import org.home.model.entity.Dish;
import org.home.model.handler.DishHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Menu", urlPatterns = {"/controller/menu"})
public class Menu extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/main.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        HttpSession session = request.getSession();

        if (session.getAttribute("dishes") == null) {
            List<Dish> dishes = DishHandler.getDishList();
            session.setAttribute("dishes", dishes);
        }

        request.getRequestDispatcher("/jsp/menu.jsp").forward(request, response);
    }
}
