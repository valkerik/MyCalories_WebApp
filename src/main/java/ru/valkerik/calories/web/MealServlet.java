package ru.valkerik.calories.web;

import org.slf4j.Logger;
import ru.valkerik.calories.dao.MealDAO;
import ru.valkerik.calories.model.Meal;
import ru.valkerik.calories.util.MealsUtil;
import ru.valkerik.calories.util.TimeUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.slf4j.LoggerFactory.getLogger;

public class MealServlet extends HttpServlet {

    private static MealDAO mealDAO = new MealDAO();
    private static final Logger log = getLogger(UserServlet.class);

    private static String INSERT_OR_EDIT = "/addEdit.jsp";
    private static String LIST_MEALS = "/meals.jsp";


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.debug("redirect");
        String forward = "";
        String action = request.getParameter("action");

        final LocalTime startTime = LocalTime.of(0, 0);
        final LocalTime endTime = LocalTime.of(23, 0);


        if (action.equalsIgnoreCase("delete")) {
            int mealId = Integer.parseInt(request.getParameter("id"));

            mealDAO.deleteMeal(mealId);
            forward = LIST_MEALS;
            request.setAttribute("mealsListExcess", MealsUtil.filteredByCycles(mealDAO.getAllMeals(), startTime, endTime, 2000));

        } else if (action.equalsIgnoreCase("edit")) {

            int mealId = Integer.parseInt(request.getParameter("id"));
            Meal meal = mealDAO.getMealById(mealId);
            request.setAttribute("meal", meal);
            request.getRequestDispatcher("/createUpdate.jsp").forward(request, response);

        } else if (action.equalsIgnoreCase("create")) {

            Meal newMeal = new Meal(LocalDateTime.now(), "new Meal", 50);
            request.setAttribute("meal", newMeal);
            request.getRequestDispatcher("/createUpdate.jsp").forward(request, response);

        } else if (action.equalsIgnoreCase("meals")) {
            forward = LIST_MEALS;
            request.setAttribute("mealsListExcess", MealsUtil.filteredByCycles(mealDAO.getAllMeals(), startTime, endTime, 2000));

        } else {
            forward = INSERT_OR_EDIT;
        }

        request.getRequestDispatcher(forward).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Meal meal = new Meal();
        LocalDateTime localDateTime = TimeUtil.parseLocalDataTime(request.getParameter("dateTime"));
        meal.setDateTime(localDateTime);
        meal.setDescription(request.getParameter("description"));
        meal.setCalories(Integer.parseInt(request.getParameter("calories")));


        mealDAO.addMeal(meal);

        request.setAttribute("mealsListExcess", MealsUtil.filteredByCycles(mealDAO.getAllMeals(), LocalTime.MIN,LocalTime.MAX, 2000));
        request.getRequestDispatcher(LIST_MEALS).forward(request, response);

    }
}
