package supermarket.application.model.adminclassDao;

public class AdminDao {
    private int id;
    private String email;
    private String password;
    AdminDao(){
        id = 000;
        email = "isrisan54@gmail.com";
        password = "1234567890";
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
