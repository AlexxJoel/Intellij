package students.examenrecupera.students.model;

import students.examenrecupera.utils.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class DaoStudent {

    //Aqui haremos la conexxio´n de la base de datos

    //Esta variable es el puente (Conexión) entre la base y la app
    Connection conexion = new MySQLConnection().getConnection(); //Aqui llamamos a la funcion


    //Esta variable es para preparar la consulta (la query que deseeas en la bd)
    PreparedStatement preparedStatement;

    //En esta guardaremos todos los resultados
    ResultSet result ;

    //Listo , Ahora prepararemos las QUERY (consultas)  en dado caso lo mas comun es el CRUD

    private final String LIST_AlUMNS = "SELECT * FROM persons.students";

    private final  String CREATE_ALUMN = "INSERT INTO `persons`.`students`(`name`,`qual1`,`qual2`,`qual3`,`qual4`,`qual5`,`average`)VALUES(?,?,?,?,?,?,?)";
    private  final  String UPDATE_STATUS = "UPDATE `persons`.`students` SET `status` = ? WHERE (`id_students` = ?)";

    private  final  String UPDATE_ALUMN = "UPDATE `persons`.`students` SET `name` =?, `qual1` = ?, `qual2` =?, `qual3` = ?, `qual4` = ?, `qual5` = ?, `average` = ? WHERE (`id_students` =?)";


    private  final  String LIST_ALUMN = "SELECT * FROM persons.students where id_students = ? ";

    //VIVAAAAAAAAAAAAAA BAD BUNNY


    public List<BeanStudent> listStudent (){
        List<BeanStudent> Mylist = new LinkedList<>();
        BeanStudent students = null;
        try{

            preparedStatement = conexion.prepareStatement(LIST_AlUMNS);
            result = preparedStatement.executeQuery();
            while (result.next()) {
                students = new BeanStudent(
                        result.getInt("id_students"),
                        result.getString("name"),
                        result.getInt("qual1"),
                        result.getInt("qual2"),
                        result.getInt("qual3"),
                        result.getInt("qual4"),
                        result.getInt("qual5"),
                        result.getInt("average"),
                        result.getInt("status")
                );


                Mylist.add(students);
            }

        }catch (SQLException e){
            System.out.println(e);
        }

        return Mylist;
    }


    //----------------------------------------------------------------------

    public boolean saveStudent(BeanStudent student){
        try {
            preparedStatement = conexion.prepareStatement(CREATE_ALUMN);
            preparedStatement.setString(1,student.getName());
            preparedStatement.setInt(2,student.getQual1());
            preparedStatement.setInt(3,student.getQual2());
            preparedStatement.setInt(4,student.getQual3());
            preparedStatement.setInt(5,student.getQual4());
            preparedStatement.setInt(6,student.getQual5());
            preparedStatement.setInt(7,student.getAverage());
            return preparedStatement.executeUpdate()==1 ;//1==1

        }catch (SQLException e){
            System.out.println(e);
        }
        return false;

    }

    //------------------------------------------------------------------------------
    public BeanStudent consultStudent (int id){
        BeanStudent student = null;
        try{

            preparedStatement = conexion.prepareStatement(LIST_ALUMN);
            preparedStatement.setInt(1,id);
            result = preparedStatement.executeQuery();
            if (result.next()) {

              student = new BeanStudent(
                      result.getInt("id_students"),
                      result.getString("name"),
                      result.getInt("qual1"),
                      result.getInt("qual2"),
                      result.getInt("qual3"),
                      result.getInt("qual4"),
                      result.getInt("qual5"),
                      result.getInt("average"),
                      result.getInt("status")

                      );

            }
            //System.out.println(song.toString());
        }catch (SQLException e){
            System.out.println(e);
        }

        return student;
    }




    public boolean disableStudent(int id, int status) {
        try {
            preparedStatement = conexion.prepareStatement(UPDATE_STATUS);
            preparedStatement.setInt(1, status);
            preparedStatement.setInt(2, id);
            return preparedStatement.executeUpdate()==1; //1==1
        }catch (SQLException e){
            System.out.println(e);
        }
        return false;

    }

    //---------------------------------------------
    public boolean updateStudents(BeanStudent student){
        try {
            preparedStatement = conexion.prepareStatement(UPDATE_ALUMN);
            preparedStatement.setString(1,student.getName());
            preparedStatement.setInt(2,student.getQual1());
            preparedStatement.setInt(3,student.getQual2());
            preparedStatement.setInt(4,student.getQual3());
            preparedStatement.setInt(5,student.getQual4());
            preparedStatement.setInt(6,student.getQual5());
            preparedStatement.setInt(7,student.getAverage());
            preparedStatement.setInt(8,student.getId_students());
            return preparedStatement.executeUpdate()==1 ;//1==1

        }catch (SQLException e){
            System.out.println(e);
        }
        return false;

    }




}
