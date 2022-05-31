package controller;

import model.Employee;
import model.Manage;
import service.ManageService;
import service.ManageServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ManageServlet", urlPatterns = "/manages")

public class ManageServlet extends HttpServlet {
    ManageService manageService=new ManageServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String act = request.getParameter("act");
        if (act == null) {
            act = "";
        }
        switch (act){
            default:
                showList(request, response);
                break;
        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Manage> manages =  manageService.findAll();
        request.setAttribute("dsl", manages);
        request.getRequestDispatcher("manage/list.jsp").forward(request, response);

    }

        @Override
        protected void doPost (HttpServletRequest request, HttpServletResponse response) throws
        ServletException, IOException {

        }
    }

