package model;

public class BeanProducts {


    private int id_products;
    private  String name;
    private double price;
    private int status;

    public BeanProducts() {
    }


    public BeanProducts(int id_products, String name, double price, int status) {
        this.id_products = id_products;
        this.name = name;
        this.price = price;
        this.status = status;
    }

    public BeanProducts(int id_products, double price) {
        this.id_products = id_products;
        this.price = price;
    }


    public int getId_products() {
        return id_products;
    }

    public void setId_products(int id_products) {
        this.id_products = id_products;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


}
