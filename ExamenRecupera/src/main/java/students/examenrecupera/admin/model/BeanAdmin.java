package students.examenrecupera.admin.model;

public class BeanAdmin {
    private  int id_user;
    private String  name;
    private String  email;
    private  String login;
    private String    pass;


    public BeanAdmin() {
    }



    public BeanAdmin(int id_user, String name, String email, String login, String pass) {
        this.id_user = id_user;
        this.name = name;
        this.email = email;
        this.login = login;
        this.pass = pass;
    }

    public BeanAdmin(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }


    @Override
    public String toString() {
        return "BeanAdmin{" +
                "id_user=" + id_user +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", login='" + login + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }
}
