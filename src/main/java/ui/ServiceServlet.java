package ui;

import lombok.SneakyThrows;
import service.IService;
import service.ServiceService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServiceServlet" , urlPatterns = "/service")
public class ServiceServlet extends HttpServlet {
    private IService iService;

    @Override
    public void init() throws ServletException {
        super.init();
        iService = new ServiceService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @SneakyThrows
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            request.setAttribute("service", iService.findAll());
            getServletContext().getRequestDispatcher("/WEB-INF/pages/service/listservice.jsp")
                    .forward(request,response);
        }catch (Exception e){
            throw e;
        }

    }
}
