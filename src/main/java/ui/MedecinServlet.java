package ui;

import lombok.SneakyThrows;
import service.IMedecin;
import service.MedecinService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MedecinServlet" ,urlPatterns = "/medecin")
public class MedecinServlet extends HttpServlet {

    private IMedecin iMedecin;

     @Override
     public void init() throws ServletException {
        super.init();
        iMedecin = new MedecinService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @SneakyThrows
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            request.setAttribute("medecin", iMedecin.findAll());
            getServletContext().getRequestDispatcher("/WEB-INF/page/medecin/listmedecin.jsp")
                    .forward(request,response);
        }catch (Exception e){
            throw e;
        }
    }
}
