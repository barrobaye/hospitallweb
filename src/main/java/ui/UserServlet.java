package ui;

import model.User;
import service.IUser;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "UserServlet" , urlPatterns = "/user")
public class UserServlet extends HttpServlet {
    private IUser iUser;
    @Override
    public void init() throws ServletException {
        super.init();
        iUser = new UserService();
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            User user = iUser.findByEmailAndPassword(email, password);
            if(user != null){
                HttpSession session =  request.getSession(true);
                session.setAttribute("user", user);
                if(user.getRoles().size() > 1){
                    response.sendRedirect("acceuil?direction=all");
                }
                else{
                    if(user.getRoles().get(0).getName().equals("Admin")){
                        response.sendRedirect("acceuil?direction=Admin");
                    }
                    else{
                        response.sendRedirect("acceuil?direction=user");
                    }
                }

            }
            else{
                request.setAttribute("error","Login ou password incorrect!");
                getServletContext().getRequestDispatcher("/WEB-INF/page/index.jsp")
                        .forward(request,response);
            }
        }
        catch (Exception e){
            request.setAttribute("error", "Une erreur s'est produite!");
            getServletContext().getRequestDispatcher("/WEB-INF/page/index.jsp")
                    .forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //response.getWriter().println("HELLO CLASS");
        getServletContext().getRequestDispatcher("/WEB-INF/page/index.jsp")
                .forward(request,response);
    }
}
