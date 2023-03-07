package ui;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import lombok.SneakyThrows;
import model.Service;
import model.Specialite;
import service.IService;
import service.ISpecialite;
import service.ServiceService;
import service.SpecialiteService;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SpecialisteServlet", urlPatterns = "/specialite")
public class SpecialisteServlet extends HttpServlet {
    private ISpecialite iSpecialite;
    private IService iService;

    @Override
    public void init() throws ServletException {
        super.init();
        iSpecialite = new SpecialiteService();
        iService = new ServiceService();
    }

    @SneakyThrows
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Post fire");
        if(request.getParameter("specialiteId")!=null){
            Specialite specialite;
            if (!request.getParameter("specialiteId").equals("")){
                specialite = iSpecialite.find(Long.parseLong(request.getParameter("specialiteId")));
            }
            else {
                specialite = new Specialite();
            }
            specialite.setLibelle(request.getParameter("libelle"));
            specialite .setService(iService.find(Long.parseLong(request.getParameter("service"))));
            iSpecialite.add(specialite);
            fillData(request,response);

        }
        else{
            Long id= Long.parseLong(request.getParameter("serviceId"));
            request.setAttribute("specialites", iSpecialite.findByService(id));
            request.setAttribute("services",iService.findAll());
            getServletContext().getRequestDispatcher("/WEB-INF/page/specialite/specialiteselect.jsp")
                    .forward(request,response);

        }
    }

    @SneakyThrows
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");

        try{
            if(action!=null){
                switch (action){
                    case"init":
                        fillData(request,response);
                        getServletContext().getRequestDispatcher("/WEB-INF/page/specialite/listspecialite.jsp")
                            .forward(request,response);
                        break;
                    case "edit":
                        Long id= Long.parseLong(request.getParameter("specialiteId"));
                        Specialite sp = iSpecialite.find(id);
                        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
                        String data = ow.writeValueAsString(sp);
                        response.getWriter().println(sp);
                        getServletContext().getRequestDispatcher("/WEB-INF/page/specialite/listspecialite.jsp")
                                .forward(request,response);
                        break;
                    case "delete":
                        Long ids= Long.parseLong(request.getParameter("specialiteId"));
                        Specialite spc = iSpecialite.find(ids);
                        iSpecialite.remove(spc);
                        response.sendRedirect("specialite?action=init");
                        getServletContext().getRequestDispatcher("/WEB-INF/page/specialite/listspecialite.jsp")
                                .forward(request,response);
                        break;
                    case "find":
                        //fillData(request,response);
                        getServletContext().getRequestDispatcher("/WEB-INF/page/specialite/listspecialite.jsp")
                                .forward(request,response);
                        break;
                }
            }

        }catch (Exception e){
            throw e;
        }
        request.setAttribute("specialite", iSpecialite.findAll());
        request.setAttribute("services", iService.findAll());
        getServletContext().getRequestDispatcher("/WEB-INF/page/specialite/listspecialite.jsp")
                .forward(request,response);
    }
    private void fillData(HttpServletRequest req, HttpServletResponse res)throws Exception {
        req.setAttribute("services",iService.findAll());
        req.setAttribute("specialites",iSpecialite.findAll());
    }
    public void specialitelist(ServletRequest req, ServletResponse res) throws Exception{
        List<Specialite> specialiteList = iSpecialite.findAll();
        req.setAttribute("specialites", specialiteList);
        getServletContext().getRequestDispatcher("/WEB-INF/page/specialite/listspecialite.jsp")
                .forward(req,res);

    }

    public void servicelist(ServletRequest req, ServletResponse res) throws Exception{
        List<Service> serviceList = iService.findAll();
        req.setAttribute("services", serviceList);
        getServletContext().getRequestDispatcher("/WEB-INF/page/specialite/listspecialite.jsp")
                .forward(req,res);
    }


}
