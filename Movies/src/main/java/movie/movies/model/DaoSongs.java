package movie.movies.model;

import movie.movies.utils.MySQLConnection;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class DaoSongs {


    //Aqui haremos la conexxio´n de la base de datos

    //Esta variable es el puente (Conexión) entre la base y la app
    Connection conexion = new MySQLConnection().getConnection(); //Aqui llamamos a la funcion


    //Esta variable es para preparar la consulta (la query que deseeas en la bd)
    PreparedStatement preparedStatement;

    //En esta guardaremos todos los resultados
    ResultSet result ;

    //Listo , Ahora prepararemos las QUERY (consultas)  en dado caso lo mas comun es el CRUD

    private final String INSERT_SONGS = "INSERT INTO `songs`(`name`,`album`,`genero`,`duration`,`artist`,`year`)VALUES(?,?,?,?,?,?);";
    private final String GENERAL_CONSULT = "SELECT * FROM songsdb.songs;";
    private final String CONSULT_UNIQUE = "SELECT * FROM songs where idsongs = ?;";
    private final String UPDATE_SONG = "UPDATE `songs` SET `name` = ?, `album` = ?, `genero` = ?, `duration` = ?, `artist` = ?, `year` = ? WHERE (`idsongs` = ?);";
    private final String DELETE_SONG = "DELETE FROM `songsdb`.`songs` WHERE (`idsongs` = ?);";


    public List<BeanSongs> listSongs (){
        List<BeanSongs> Mylist = new LinkedList<>();
        BeanSongs song = null;
        try{

            preparedStatement = conexion.prepareStatement(GENERAL_CONSULT);
            result = preparedStatement.executeQuery();
            while (result.next()) {
                song = new BeanSongs();

                song.setId(result.getInt("idsongs"));
                song.setName(result.getString("name"));
                song.setAlbum(result.getString("album"));
                song.setGenero(result.getString("genero"));
                song.setArtist(result.getString("artist"));
                song.setDuration(result.getInt("duration"));
                song.setYear(result.getDate("year"));
                Mylist.add(song);
            }

        }catch (SQLException e){
            System.out.println(e);
        }

        return Mylist;
    }


    //----------------------------------------------------------------------

    public boolean saveSong(BeanSongs song){
        try {
            preparedStatement = conexion.prepareStatement(INSERT_SONGS);
            preparedStatement.setString(1, song.getName());
            preparedStatement.setString(2, song.getAlbum());
            preparedStatement.setString(3, song.getGenero());
            preparedStatement.setInt(4,song.getDuration());
            preparedStatement.setString(5,song.getArtist());
           preparedStatement.setDate(6, new Date(song.getYear().getTime()));

           return preparedStatement.executeUpdate()==1 ;//1==1

        }catch (SQLException e){
            System.out.println(e);
        }
        return false;

    }

    //------------------------------------------------------------------------------
    public BeanSongs consultSong (int id){
        BeanSongs song = null;
        try{

            preparedStatement = conexion.prepareStatement(CONSULT_UNIQUE);
            preparedStatement.setInt(1,id);
            result = preparedStatement.executeQuery();
            if (result.next()) {
                song = new BeanSongs();
                song.setId(result.getInt("idsongs"));
                song.setName(result.getString("name"));
                song.setAlbum(result.getString("album"));
                song.setGenero(result.getString("genero"));
                song.setArtist(result.getString("artist"));
                song.setDuration(result.getInt("duration"));
                song.setYear(result.getDate("year"));

            }
            //System.out.println(song.toString());
        }catch (SQLException e){
            System.out.println(e);
        }

        return song;
    }




    public boolean deletePerson(int id) {
        try {
            preparedStatement = conexion.prepareStatement(DELETE_SONG);
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate()==1; //1==1
        }catch (SQLException e){
            System.out.println(e);
        }
        return false;

    }

    //---------------------------------------------
    public boolean updateSong(BeanSongs song){
        try {
            preparedStatement = conexion.prepareStatement(UPDATE_SONG);
            preparedStatement.setString(1, song.getName());
            preparedStatement.setString(2, song.getAlbum());
            preparedStatement.setString(3, song.getGenero());
            preparedStatement.setInt(4,song.getDuration());
            preparedStatement.setString(5,song.getArtist());
            preparedStatement.setDate(6, new Date(song.getYear().getTime()));
            preparedStatement.setInt(7,song.getId());
            return preparedStatement.executeUpdate()==1 ;//1==1

        }catch (SQLException e){
            System.out.println(e);
        }
        return false;

    }
}
