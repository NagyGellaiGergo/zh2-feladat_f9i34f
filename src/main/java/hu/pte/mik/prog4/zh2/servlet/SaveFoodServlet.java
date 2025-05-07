package hu.pte.mik.prog4.zh2.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import hu.pte.mik.prog4.zh2.service.FoodService;

import java.io.IOException;

public class SaveFoodServlet extends HttpServlet {

    private final FoodService foodService = new FoodService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var id = req.getParameter("id");
        if (id != null) {
            var food = this.foodService.findById(Long.valueOf(id));
            req.setAttribute("food", food);
        }
        req.getRequestDispatcher("/saveFood.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        var idParam = req.getParameter("id");
        var id = idParam == null || "".equals(idParam) ? null : Long.valueOf(idParam);
        var restaurantName = req.getParameter("restaurantName");
        var foodName = req.getParameter("foodName");
        var price = req.getParameter("price");
        this.foodService.save(id, restaurantName, foodName, price);

        resp.sendRedirect("food-list");
    }

}
