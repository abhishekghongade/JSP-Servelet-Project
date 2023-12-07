package com.jbk.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jbk.entity.Custinfo;
import com.jbk.service.Service;

@WebServlet("/loginpage")
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String uname = request.getParameter("username");
        String pass = request.getParameter("password");

        Service service = new Service();
        ArrayList<Custinfo> al;
        boolean loginSuccessful = false;

        try {
            al = service.getInfo();
            
            for (Custinfo custinfo : al) {
                if (uname.equals(custinfo.getUsername()) && pass.equals(custinfo.getPassword())) {
                    loginSuccessful = true;
                    break;
                }
            }

            if (loginSuccessful) {
                System.out.println("Login successful");
                RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
                request.setAttribute("uname", uname.toUpperCase());
                rd.forward(request, response);
            } else {
                System.out.println("Login failed...");
                request.setAttribute("msg", "Username and password are incorrect.");
                RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                
                rd.forward(request, response);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            // Handle the exception appropriately (e.g., show an error page).
        }

        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}

