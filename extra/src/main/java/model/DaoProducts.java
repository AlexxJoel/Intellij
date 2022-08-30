package model;

import utils.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoProducts {


    public List<BeanProducts> listProducts() {

        List<BeanProducts>  listProducts = new ArrayList<>();

        try {
            Connection connection = MySQLConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from products");
            while (rs.next()){
                BeanProducts products = new BeanProducts();
                products.setId_products(rs.getInt("id_products"));
                products.setName(rs.getString("name"));
                products.setPrice(rs.getDouble("price"));
                products.setStatus(rs.getInt("status"));

                listProducts.add(products);
            };

            rs.close();
            connection.close();
            statement.close();

        } catch(Exception e) {
            e.printStackTrace();
        }

        return listProducts;
    }


    //-----------------------------------------------------------------------------------------------------
    public boolean saveProducts(BeanProducts products) {
        boolean result = false;

        try
                (Connection con  = MySQLConnection.getConnection();
                 PreparedStatement pstm = con.prepareStatement(
                         "UPDATE `shop`.`products` SET `price` = ? WHERE (`id_products` = ?)");

                )


        {
            pstm.setInt(2,products.getId_products());
            pstm.setDouble(1,products.getPrice());
            result = pstm.executeUpdate() == 1;


        } catch(Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    //-----------------------------------------------------------------------------------------------------------
    public boolean disabledStatus(BeanProducts products) {
        boolean result = false;

        try
                (Connection con  = MySQLConnection.getConnection();
                 PreparedStatement pstm = con.prepareStatement(
                         "UPDATE `shop`.`products` SET `status` = ? WHERE (`id_products` = ?)" );

                )


        {
            pstm.setInt(1, products.getStatus());
            pstm.setInt(2,products.getId_products());
            result = pstm.executeUpdate() == 1;

        } catch(Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    //------------------------------------------------------------------------------------------------------------
    public double selling() {
        double priceSelling = 0.0;
        try {
            Connection connection = MySQLConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select sum(price) as price from products where price !=  ''");
            if (rs.next()){
               priceSelling= rs.getDouble("price");
            };

            rs.close();
            connection.close();
            statement.close();

        } catch(Exception e) {
            e.printStackTrace();
        }


        return priceSelling;
    }


    //----------------------------------------------------------
    public double totalCanceled() {
        double canceled = 0.0;
        try {
            Connection connection = MySQLConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select sum(price) as price from products where status =0;");
            if (rs.next()){
                canceled= rs.getDouble("price");
            };

            rs.close();
            connection.close();
            statement.close();

        } catch(Exception e) {
            e.printStackTrace();
        }


        return canceled;
    }


    public boolean reset(int id){
        boolean result = false;
        try
                (Connection con  = MySQLConnection.getConnection();
                 PreparedStatement pstm = con.prepareStatement(
                         "UPDATE `shop`.`products` SET `price` = ?, `status` = ? WHERE (`id_products` = ?)" );

                )
        {
            pstm.setInt(1, 0);
            pstm.setInt(2,1);
            pstm.setInt(3,id);
            result = pstm.executeUpdate() == 1;

        } catch(Exception e) {
            e.printStackTrace();
        }
        return result;
    }


  /*  public static void main(String[] args) {
        double vendidos = new DaoProducts().selling();
        double canceladso = new DaoProducts().totalCanceled();
        double neto = vendidos - canceladso;


        System.out.println(vendidos + "   "+ canceladso + "  " + neto );
    }*/


}
