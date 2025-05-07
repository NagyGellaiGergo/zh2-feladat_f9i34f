package hu.pte.mik.prog4.zh2.servlet;

import hu.pte.mik.prog4.zh2.service.FoodService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class FoodListServlet extends HttpServlet {

    private final FoodService foodService = new FoodService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("foods", this.foodService.findAll());
        req.getRequestDispatcher("/foodList.jsp")
                .forward(req, resp);
    }
}
