package controller;

import model.Employee;
import model.Manage;
import service.EmployeeService;
import service.EmployeeServiceImpl;
import service.ManageService;
import service.ManageServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HomeServlet", urlPatterns = "/home")
public class HomeServlet extends HttpServlet {
    EmployeeService employeeService = new EmployeeServiceImpl();
    ManageService manageService= new ManageServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String classId = request.getParameter("classId");
        String findName = request.getParameter("findName");
        List<Employee> employees = employeeService.findAll();
        request.setAttribute("employees",employees );
        List<Manage> manages = manageService.findAll();
        if (classId != null) {
            manages = manageService.findAllByClass(Integer.parseInt(classId));
        }
        if (findName != null) {
            manages = manageService.findAllByNameContains(findName);
        }
        request.setAttribute("manages", manages);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
