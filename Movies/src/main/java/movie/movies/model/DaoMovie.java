package movie.movies.model;

import movie.movies.utils.MySQLConnection;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoMovie {



    //Aqui haremos la conexxio´n de la base de datos

    //Esta variable es el puente (Conexión) entre la base y la app
    Connection conexion = new MySQLConnection().getConnection(); //Aqui llamamos a la funcion


    //Esta variable es para preparar la consulta (la query que deseeas en la bd)
    PreparedStatement preparedStatement;

    //En esta guardaremos todos los resultados
    ResultSet result ;

    //Listo , Ahora prepararemos las QUERY (consultas)  en dado caso lo mas comun es el CRUD

    private final String INSERT_MOVIE = "INSERT INTO `movies`.`films`(`name`,`description`,`publish_date`,`actors`,`duration`,`image`,`ranking`)VALUES(?,?,?,?,?,?,?)";
    private final String GENERAL_MOVIE = "SELECT * FROM movies.films;";
    private final String CONSULT_UNIQUE = "SELECT * FROM movies.films  where id = ?";
    private final String UPDATE_MOVIE = "UPDATE `movies`.`films` SET `name` = ?, `description` = ?, `publish_date` = ?, `actors` = ?, `ranking` = ?, `duration` =  ? WHERE (`id` = ?);";
    private final String DELETE_MOVIE = "DELETE FROM `movies`.`films` WHERE (`id` = ?);";
    //aqui esta la consulta para actualizar solo la imagen
    private final String  UPDATE_IMAGE = "UPDATE films  SET image=?  WHERE id = ?;";



    public List<BeanMovie> listMovie() {
        List<BeanMovie> listMovies = new ArrayList<>();
        BeanMovie movie = null;
        try{

            preparedStatement = conexion.prepareStatement(GENERAL_MOVIE);
            result = preparedStatement.executeQuery();
            while (result.next()) {
                movie = new BeanMovie();
                movie.setId(result.getInt("id"));
                movie.setName(result.getString("name"));
                movie.setDescription(result.getString("description"));
                movie.setPublish_date(result.getDate("publish_date"));
                movie.setActors(result.getString("actors"));
                movie.setDuration(result.getInt("duration"));
                movie.setRanking(result.getInt("ranking"));

                byte[] image = result.getBytes("image");
                String imageStr = Base64.getEncoder().encodeToString(image);
                movie.setImageToShow(imageStr);

                movie.setStatus(result.getInt("status"));
                listMovies.add(movie);
            }

        }catch (SQLException e){
            System.out.println(e);
        }

        return listMovies;
    }





    //----------------------------------------------------------------------

    public boolean saveMovie(BeanMovie movie){
        try {
            preparedStatement = conexion.prepareStatement(INSERT_MOVIE);
            preparedStatement.setString(1, movie.getName());
            preparedStatement.setString(2, movie.getDescription());
            preparedStatement.setDate(3, new Date(movie.getPublish_date().getTime()));
            preparedStatement.setString(4,movie.getActors());
            preparedStatement.setInt(5 , movie.getDuration());
            preparedStatement.setBlob(6, movie.getImageToInsert());
            preparedStatement.setInt(7, movie.getRanking());
            return preparedStatement.executeUpdate()==1 ;//1==1

        }catch (SQLException e){
            System.out.println(e);
        }
        return false;

    }

    //------------------------------------------------------------------------------
    public BeanMovie consultMovie (int id){
        BeanMovie movie = null;
        try{

            preparedStatement = conexion.prepareStatement(CONSULT_UNIQUE);
            preparedStatement.setInt(1,id);
            result = preparedStatement.executeQuery();
            if (result.next()) {
                movie = new BeanMovie();
                movie.setId(result.getInt("id"));
                movie.setName(result.getString("name"));
                movie.setDescription(result.getString("description"));
                movie.setPublish_date(result.getDate("publish_date"));
                movie.setActors(result.getString("actors"));
                movie.setDuration(result.getInt("duration"));
                movie.setRanking(result.getInt("ranking"));

                byte[] image = result.getBytes("image");
                String imageStr = Base64.getEncoder().encodeToString(image);
                movie.setImageToShow(imageStr);

                movie.setStatus(result.getInt("status"));

            }
            //System.out.println(song.toString());
        }catch (SQLException e){
            System.out.println(e);
        }

       return movie;
    }




    public boolean deleteMovie(int id) {
        try {
            preparedStatement = conexion.prepareStatement(DELETE_MOVIE);
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate()==1; //1==1
        }catch (SQLException e){
            System.out.println(e);
        }
        return false;

    }

    //---------------------------------------------
    public boolean updateMovie(BeanMovie movie){
        try {
            preparedStatement = conexion.prepareStatement(UPDATE_MOVIE);
            preparedStatement.setString(1, movie.getName());
            preparedStatement.setString(2, movie.getDescription());
            preparedStatement.setDate(3, new Date(movie.getPublish_date().getTime()));
            preparedStatement.setString(4,movie.getActors());
            preparedStatement.setInt(6 , movie.getDuration());
            preparedStatement.setInt(5, movie.getRanking());
            preparedStatement.setInt(7, movie.getId());
            return preparedStatement.executeUpdate()==1 ;//1==1

        }catch (SQLException e){
            System.out.println(e);
        }
        return false;

    }


    //metodo para cambiar la imagen que no se me olvide xd
    public boolean updateImage(BeanMovie movie, InputStream image){
        try {
            preparedStatement = conexion.prepareStatement(UPDATE_IMAGE);
            preparedStatement.setBlob(1,image);
            preparedStatement.setInt(2, movie.getId());

            return preparedStatement.executeUpdate()==1 ;

        }catch (SQLException e){
            Logger.getLogger(DaoMovie.class.getName()).log(Level.SEVERE, "Error en updateImage -> ", e);

        }return false;
    }
}
