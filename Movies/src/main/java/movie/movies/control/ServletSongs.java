package movie.movies.control;

import movie.movies.model.DaoSongs;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "ServletSongs", urlPatterns = {
        "/ServletSongs",
        "/list-songs", //get
        "/get-song", //Get
        "/create-song", //get
        "/save-song", //Post
        "/update-song", //Post
        "/delete-song" //Delete
}  )
public class ServletSongs extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DaoSongs daoSongs = new DaoSongs();
        String option = request.getServletPath();


        switch (option) {
            case "/list-songs":


                List<BeanSongs> listSongs = daoSongs.listSongs();
                request.setAttribute("list", listSongs);
                request.getRequestDispatcher("/WEB-INF/view/list-songs.jsp").forward(request, response);

                break;

            case "/create-song":

                request.getRequestDispatcher("/WEB-INF/view/create-songs.jsp").forward(request, response);

                break;


            case "/get-song":
                String idString = request.getParameter("id") != null ? request.getParameter("id") : "0";
                try {
                    int id = Integer.parseInt(idString);
                    BeanSongs song = daoSongs.consultSong(id); //DAO consulta a la db
                    request.setAttribute("songX", song);
                    request.getRequestDispatcher("/WEB-INF/view/get-song.jsp").forward(request,response);
                } catch (Exception e) {
                    response.sendRedirect("list-persons");
                }

                break;
            default:
        }



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DaoSongs daoSongs = new DaoSongs();
        String option = request.getServletPath();

        switch (option) {

            case "/create-song":

                try {
                    //recibir valores del formulario
                    String name = request.getParameter("name") != null ? (request.getParameter("name")) : "";
                    String album = request.getParameter("album") != null ? (request.getParameter("album")) : "";
                    String genero = request.getParameter("genero") != null ? (request.getParameter("genero")) : "";
                    String duration = request.getParameter("duration") != null ? (request.getParameter("duration")) : "";
                    String artist = request.getParameter("artist") != null ? (request.getParameter("artist")) : "";
                   //aqui es para que pueda yo leer la fecha
                    String year = request.getParameter("year") != null ? (request.getParameter("year")) : "";
                    Date yearInsert = new SimpleDateFormat("yyyy-MM-dd").parse(year);


                    BeanSongs song = new BeanSongs();
                    song.setName(name);
                    song.setAlbum(album);
                    song.setGenero(genero);
                    song.setDuration(Integer.parseInt(duration));
                    song.setArtist(artist);
                    song.setYear(yearInsert);
                    boolean result = daoSongs.saveSong(song);
                    response.sendRedirect("list-songs?result-save=" + (result ? "ok" : "error"));
                } catch (Exception e) {
                    e.printStackTrace();
                    response.sendRedirect("list-songs");
                }
                break;


                //----------------Para eliminar
            case "/delete-song":
                String idStringDelete = request.getParameter("id") != null ? request.getParameter("id") : "0";

                try {
                    int id = Integer.parseInt(idStringDelete);
                    boolean result = daoSongs.deletePerson(id);
                    response.sendRedirect("list-songs?result-delete="+(result ? "ok" : "error"));
                } catch (Exception e) {
                    response.sendRedirect("list-songs");                }

                break;


            case "/update-song":
                try {
                    String idUpdate = request.getParameter("id") != null ? request.getParameter("id") : "0";

                    //recibir valores del formulario
                    String name = request.getParameter("name") != null ? (request.getParameter("name")) : "";
                    String album = request.getParameter("album") != null ? (request.getParameter("album")) : "";
                    String genero = request.getParameter("genero") != null ? (request.getParameter("genero")) : "";
                    String duration = request.getParameter("duration") != null ? (request.getParameter("duration")) : "";
                    String artist = request.getParameter("artist") != null ? (request.getParameter("artist")) : "";
                    //aqui es para que pueda yo leer la fecha
                    String year = request.getParameter("year") != null ? (request.getParameter("year")) : "";
                    Date yearInsert = new SimpleDateFormat("yyyy-MM-dd").parse(year);

                    BeanSongs song = new BeanSongs();
                    song.setId(Integer.parseInt(idUpdate));
                    song.setName(name);
                    song.setAlbum(album);
                    song.setGenero(genero);
                    song.setDuration(Integer.parseInt(duration));
                    song.setArtist(artist);
                    song.setYear(yearInsert);
                    boolean result = daoSongs.updateSong(song);

                    response.sendRedirect("list-songs?result-update="+(result ? "ok" : "error"));


                } catch (Exception e) {
                    e.printStackTrace();
                    response.sendRedirect("list-songs");
                }

                break;


            default:
                System.out.println("pospt");
        }


    }
}
