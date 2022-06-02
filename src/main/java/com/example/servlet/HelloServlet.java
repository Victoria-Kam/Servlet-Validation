package com.example.servlet;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

    private OurClass ourClass;

    public void init() {
        ourClass = new OurClass();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ourClass.setEmail(request.getParameter("email"));
        ourClass.setNumber(request.getParameter("mobNumber"));
        ourClass.ourMain();

        if (ourClass.isCorrectEmail() && ourClass.isCorrectNumber()) {          // если валидация прошла успешно
            request.setAttribute("successValidation", "Валидация прошла успешно!");
            request.getRequestDispatcher("success.jsp").forward(request, response);
            ourClass.resetData();
        } else {
            if (!ourClass.isCorrectNumber() && !ourClass.isCorrectEmail()) {    // если валидация не удалась
                request.setAttribute("messageNumber", "неправильно указан номер");
                request.setAttribute("messageEmail", "неправильно указана почта");
                request.getRequestDispatcher("index.jsp").forward(request, response);
                ourClass.resetData();
            } else if (!ourClass.isCorrectEmail()) {                            // если неправильно введена почта
                request.setAttribute("messageEmail", "неправильно указана почта");
                request.getRequestDispatcher("index.jsp").forward(request, response);
                ourClass.resetData();
            }
            else if (!ourClass.isCorrectNumber()) {                             // если неправильно введен номер
                request.setAttribute("messageNumber", "неправильно указан номер");
                request.getRequestDispatcher("index.jsp").forward(request, response);
                ourClass.resetData();
            }
        }

    }
//    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        response.setContentType("text/html");
//
//        // Hello
//        PrintWriter out = response.getWriter();
//        out.println("<html><body>");
//        out.println("<h1>" + message + "</h1>");
//        out.println("</body></html>");
//    }

    public void destroy() {
    }
}