package supermarket.application.model.userclassDao;

import java.sql.*;

import supermarket.application.controller.DbConnection;

public class UserDbDao {
    public boolean udbDao(String name, String email, String epassword){
        try {
            System.out.println("Connection is runnning");
            Connection con = DbConnection.getConnection();
            Statement st = con.createStatement();
            String check = "select email from users where email = ?";
            PreparedStatement checkStmt = con.prepareStatement(check);
            checkStmt.setString(1, email);
            ResultSet rs = checkStmt.executeQuery();
            int ro = 0;
            while(rs.next()){
                ro++;
            }
            if(ro == 0) {
                String query = "insert into users (username, email, password ) values (?, ?, ?)";
                Connection con1 = DbConnection.getConnection();
                PreparedStatement pst = con1.prepareStatement(query);
                pst.setString(1, name);
                pst.setString(2, email);
                pst.setString(3, epassword);
                int rows = pst.executeUpdate();
                if (rows > 0) {
                    return true;
                }
            }
            else{
                return  false;
            }
        }
        catch (SQLException e) {
            return false;
        }
        return false;
    }

}
