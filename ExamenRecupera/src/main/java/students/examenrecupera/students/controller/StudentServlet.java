package students.examenrecupera.students.controller;

import students.examenrecupera.admin.model.BeanAdmin;
import students.examenrecupera.admin.model.DaoAdmin;
import students.examenrecupera.students.model.BeanStudent;
import students.examenrecupera.students.model.DaoStudent;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentServlet", value = "/StudentServlet")
public class
StudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        BeanStudent beanStudent = new BeanStudent();
        DaoStudent daoStudent = new DaoStudent();

        switch (accion){
            case "liste":
               // System.out.println("listar");
                List<BeanStudent> listStudent =  daoStudent.listStudent();
                request.setAttribute("list", listStudent);
                request.getRequestDispatcher("/WEB-INF/view/list.jsp").forward(request,response);
                break;


            case "createStudent":
                request.getRequestDispatcher("/WEB-INF/view/create.jsp").forward(request,response);
                break;

            case "getStudent":
                int idString = Integer.parseInt(request.getParameter("id") != null ? request.getParameter("id") : "0");
                BeanStudent student = daoStudent.consultStudent(idString);
                request.setAttribute("obj", student);
                request.getRequestDispatcher("/WEB-INF/view/getStudent.jsp").forward(request,response);
                break;







            default:
                request.getRequestDispatcher("/WEB-INF/view/list.jsp").forward(request,response);

        }


    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        BeanStudent beanStudent1 = null;
        DaoStudent daoStudent = new DaoStudent();
        boolean result;

        switch (accion){
            case "add":
                String name = request.getParameter("name") != null ? (request.getParameter("name")) : "";
                int calf1 = request.getParameter("cal1") != null ? Integer.parseInt((request.getParameter("cal1"))) : 0;
                int calf2 = request.getParameter("cal2") != null ? Integer.parseInt((request.getParameter("cal2"))) : 0;
                int calf3 = request.getParameter("cal3") != null ? Integer.parseInt((request.getParameter("cal3"))) : 0;
                int calf4 = request.getParameter("cal4") != null ? Integer.parseInt((request.getParameter("cal4"))) : 0;
                int calf5 = request.getParameter("cal5") != null ? Integer.parseInt((request.getParameter("cal5"))) : 0;

                int average = (calf1+calf2+calf3+calf4+calf5)/5;
                beanStudent1 = new BeanStudent(name,calf1,calf2,calf3,calf4,calf5,average);


                 result = daoStudent.saveStudent(beanStudent1);
                response.sendRedirect("StudentServlet?accion=liste&result-save=" + (result ? "ok" : "error"));

                break;


            case "status":
                System.out.println("Status");
                int idString = Integer.parseInt(request.getParameter("id") != null ? request.getParameter("id") : "0");
                int status = Integer.parseInt(request.getParameter("state") != null ? request.getParameter("state") : "0");
                 result = daoStudent.disableStudent(idString,status);
                response.sendRedirect("StudentServlet?accion=liste&result-delete=" + (result ? "ok" : "error"));

                break;

            case "update":
                int id = Integer.parseInt(request.getParameter("id") != null ? request.getParameter("id") : "0");
                String nameU = request.getParameter("name") != null ? (request.getParameter("name")) : "";
                int calf1U = request.getParameter("cal1") != null ? Integer.parseInt((request.getParameter("cal1"))) : 0;
                int calf2U = request.getParameter("cal2") != null ? Integer.parseInt((request.getParameter("cal2"))) : 0;
                int calf3U = request.getParameter("cal3") != null ? Integer.parseInt((request.getParameter("cal3"))) : 0;
                int calf4U = request.getParameter("cal4") != null ? Integer.parseInt((request.getParameter("cal4"))) : 0;
                int calf5U = request.getParameter("cal5") != null ? Integer.parseInt((request.getParameter("cal5"))) : 0;

                int averageU = (calf1U+calf2U+calf3U+calf4U+calf5U)/5;
                beanStudent1 = new BeanStudent(id, nameU,calf1U,calf2U,calf3U,calf4U,calf5U,averageU);


                result = daoStudent.updateStudents(beanStudent1);
                response.sendRedirect("StudentServlet?accion=liste&result-update=" + (result ? "ok" : "error"));

                break;


            default:
                response.sendRedirect("StudentServlet?accion=liste");


        }
    }
}
