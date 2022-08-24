package movie.movies.control;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletMovie",  urlPatterns = {
        "/ServletMovie",
        "/list-movies", //get
        "/get-movie", //Get
        "/create-movie", //get
        "/save-movie", //Post
        "/update-movie", //Post
        "/delete-movie" //Delete
}  )
public class ServletMovie extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
