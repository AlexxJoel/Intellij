package movie.movies.control;

import movie.movies.model.BeanMovie;
import movie.movies.model.DaoMovie;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@MultipartConfig(maxFileSize = 1024*1024*100)

@WebServlet(name = "ServletMovie",  urlPatterns = {
        "/ServletMovie",
        "/list-movie", //get
        "/get-movie", //Get
        "/create-movies", //get
        "/save-movie", //Post
        "/update-movie", //Post
        "/delete-movie", //Delete,
        "/change-image",
        "/updateImage"
}  )
public class ServletMovie extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        DaoMovie daoMovie = new DaoMovie();
        String option = request.getServletPath();


        switch (option) {
            case "/list-movie":

                List<BeanMovie> listMovie = daoMovie.listMovie();
                request.setAttribute("list", listMovie);
                request.getRequestDispatcher("/WEB-INF/view/list-movies.jsp").forward(request, response);

                break;



            case "/create-movies":

                request.getRequestDispatcher("/WEB-INF/view/create-movie.jsp").forward(request, response);

                break;


            case "/get-movie":
                String idString = request.getParameter("id") != null ? request.getParameter("id") : "0";
                try {
                    int id = Integer.parseInt(idString);
                    BeanMovie movie = daoMovie.consultMovie(id); //DAO consulta a la db
                    request.setAttribute("movieX", movie);
                    request.getRequestDispatcher("/WEB-INF/view/get-movie.jsp").forward(request,response);
                } catch (Exception e) {
                    response.sendRedirect("list-persons");
                }

                break;
            default:

        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        DaoMovie daoMovie = new DaoMovie();
        String option = request.getServletPath();

        switch (option) {

            case "/save-movie":

                try {
                    //recibir valores del formulario
                    String name = request.getParameter("name") != null ? (request.getParameter("name")) : "";
                    String description = request.getParameter("description") != null ? (request.getParameter("description")) : "";
                    String publish_date = request.getParameter("publish_date") != null ? (request.getParameter("publish_date")) : "";
                    String actors = request.getParameter("actors") != null ? (request.getParameter("actors")) : "";
                    String duration = request.getParameter("duration") != null ? (request.getParameter("duration")) : "";
                    String ranking = request.getParameter("ranking") != null ? (request.getParameter("ranking")) : "";
                    Part filePart = request.getPart("image");
                    InputStream image = filePart.getInputStream();
                    //aqui es para que pueda yo leer la fecha
                    Date date = new SimpleDateFormat("yyyy-MM-dd").parse(publish_date);

                    BeanMovie movie = new BeanMovie();
                    movie.setName(name);
                    movie.setDescription(description);
                    movie.setPublish_date(date);
                    movie.setActors(actors);
                    movie.setRanking(Integer.parseInt(ranking));
                    movie.setDuration(Integer.parseInt(duration));
                    movie.setImageToInsert(image);

                    boolean result = daoMovie.saveMovie(movie);
                    response.sendRedirect("list-movie?result-save=" + (result ? "ok" : "error"));
                } catch (Exception e) {
                    e.printStackTrace();
                    response.sendRedirect("list-movie");
                }
                break;



            case "/update-movie":

                try {
                    String idUpdate = request.getParameter("id") != null ? request.getParameter("id") : "0";

                    String name = request.getParameter("name") != null ? (request.getParameter("name")) : "";
                    String description = request.getParameter("description") != null ? (request.getParameter("description")) : "";
                    String publish_date = request.getParameter("publish_date") != null ? (request.getParameter("publish_date")) : "";
                    String actors = request.getParameter("actors") != null ? (request.getParameter("actors")) : "";
                    String duration = request.getParameter("duration") != null ? (request.getParameter("duration")) : "";
                    String ranking = request.getParameter("ranking") != null ? (request.getParameter("ranking")) : "";

                    //aqui es para que pueda yo leer la fecha
                    Date date = new SimpleDateFormat("yyyy-MM-dd").parse(publish_date);

                    BeanMovie movie = new BeanMovie();
                    movie.setId(Integer.parseInt(idUpdate));
                    movie.setName(name);
                    movie.setDescription(description);
                    movie.setPublish_date(date);
                    movie.setActors(actors);
                    movie.setRanking(Integer.parseInt(ranking));
                    movie.setDuration(Integer.parseInt(duration));

                  //  System.out.println(movie.toString());

                    boolean result = daoMovie.updateMovie(movie);


                    response.sendRedirect("list-movie?result-update="+(result ? "ok" : "error"));


                } catch (Exception e) {
                    e.printStackTrace();
                    response.sendRedirect("list-movie");
                }

                break;
            case "/delete-movie":
                String idStringDelete = request.getParameter("id") != null ? request.getParameter("id") : "0";

                try {
                    int id = Integer.parseInt(idStringDelete);
                    boolean result = daoMovie.deleteMovie(id);
                    response.sendRedirect("list-movie?result-delete="+(result ? "ok" : "error"));
                } catch (Exception e) {
                    response.sendRedirect("list-movie");                }

                break;
            case "/updateImage":
                Part filePart3 = request.getPart("image");
                InputStream image3 = filePart3.getInputStream();
                String id3 = request.getParameter("id");
                try{
                    BeanMovie movie3 = new BeanMovie();
                    movie3.setId(Integer.parseInt(id3));
                    boolean result = daoMovie.updateImage(movie3, image3);
                    response.sendRedirect("list-movie?result-updateImage="+(result ? "ok" : "error"));
                } catch (Exception e) {
                    response.sendRedirect("list-movie");                }

                break;

            default:
                System.out.println("post");
        }

    }
}
