package ui;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "acceuil" , urlPatterns = "/acceuil")
public class acceuil extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String redirect = request.getParameter("direction");
        if(redirect.equals("all")){
            getServletContext().getRequestDispatcher("/WEB-INF/page/acceuiladminuser.jsp")
                    .forward(request,response);
        }
        else{
            if(redirect.equals("Admin")){
                getServletContext().getRequestDispatcher("/WEB-INF/page/acceuiladmin.jsp")
                        .forward(request,response);
            }
            else{
                getServletContext().getRequestDispatcher("/WEB-INF/page/acceuiluser.jsp")
                        .forward(request,response);
            }
        }
    }
}
