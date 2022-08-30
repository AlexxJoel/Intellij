package students.examenrecupera.admin.controller;

import students.examenrecupera.admin.model.BeanAdmin;
import students.examenrecupera.admin.model.DaoAdmin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AdminServlet", value = "/AdminServlet")
public class AdminServlet extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        BeanAdmin admin = new BeanAdmin();
        DaoAdmin daoAdmin = new DaoAdmin();
        switch (accion) {
            case "login":
                request.getRequestDispatcher("/index.jsp").forward(request, response);
                break;

            case "start":
                request.getRequestDispatcher("StudentServlet?accion=liste").forward(request, response);
                break;

            case "end":
                HttpSession sessionLogin = request.getSession(false);
                sessionLogin.removeAttribute("id_user");
                sessionLogin.removeAttribute("name");
                sessionLogin.invalidate();
                request.getRequestDispatcher("/index.jsp").forward(request,response);

                break;

            default:
                request.getRequestDispatcher("/index.jsp").forward(request,response);

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        BeanAdmin admin = new BeanAdmin();
        DaoAdmin daoAdmin = new DaoAdmin();
        HttpSession sesionLogin;
        sesionLogin =request.getSession(true);


        switch (accion){
            case "access":
                String user = request.getParameter("user") != null ? (request.getParameter("user")) : "";
                String pass = request.getParameter("pass") != null ? (request.getParameter("pass")) : "";
                admin = new BeanAdmin(user,pass);
                admin = daoAdmin.loginAdmin(admin);


                    sesionLogin.setAttribute("id_user", admin.getId_user());
                    sesionLogin.setAttribute("name",admin.getName());


                response.sendRedirect("AdminServlet?accion=login&result-access="+(admin.getId_user()==0 ? "error" : "ok"));

                break;

            default:

        }


    }
}
