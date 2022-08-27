package students.examenrecupera.admin.model;


import students.examenrecupera.utils.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoAdmin {

    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;

    private  final  String QUERY_LOGIN ="SELECT * FROM persons.admin where login = ? AND pass = ?";



    public BeanAdmin loginAdmin(BeanAdmin admin){
        try {
            conn = new MySQLConnection().getConnection();
            pstm = conn.prepareStatement(QUERY_LOGIN);
            pstm.setString(1, admin.getLogin());
            pstm.setString(2, admin.getPass());
            rs = pstm.executeQuery();
            admin = new BeanAdmin();

            if (rs.next()){
              admin.setId_user(rs.getInt("id_user"));
              admin.setName(rs.getString("name"));
              admin.setEmail(rs.getString("email"));
            }else{
                admin.setId_user(0);
            }

        }catch (SQLException e){
            System.out.println(e);
        }finally {
            System.err.println("Cerrar conexion");
        }
        System.out.printf(admin.toString());

        return admin;

    }




    public static void main(String[] args) {

        //login
        BeanAdmin dao = new BeanAdmin("admin","1234");
        new DaoAdmin().loginAdmin(dao);


        //Test search
        //new AdminDao().watchAdmins();

        //Test crete
      /* AdminBean dao = new AdminBean("AlexxJoel","joel@utez.edu.mx","123",2);
       Boolean res = new  AdminDao().registerAdmin(dao);
       System.out.println(res);*/

        // Test to find just one
        //new AdminDao().findOneAdmin("3");


        //test update
        /*AdminBean dao = new AdminBean(3,"Jose","mike@gmail.com",1,null);
        dao.setPsw("123456");
        Boolean res = new  AdminDao().updateAdmin(dao);
        System.out.println(res);*/

        //Test delete
        //new AdminDao().deleteAdmin(3);



    }

    /*public void msj(){
        System.out.println("Mensjae" + new Date());
    }
    public static void main(String[] args) {
        Timer timer = new Timer();
        TimerTask tarea = new TimerTask() {
            @Override
            public void run() {
                System.out.println("msj");
            }


        };
        timer.schedule( tarea , 0 ,1000);

    }*/

}
