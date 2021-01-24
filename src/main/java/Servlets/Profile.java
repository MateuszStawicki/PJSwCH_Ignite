package Servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class Profile extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        request.getRequestDispatcher("link.html").include(request, response);

        HttpSession session = request.getSession(false);
        String login = (String) session.getAttribute("login");
        if (login != null) {
            out.println("Witaj " + login );
            out.println(", numer sesji: " + session.getId());
        } else {
            out.print("Najpierw musisz się zalogować");
            request.getRequestDispatcher("login.html").include(request, response);
        }
        out.close();
    }
}