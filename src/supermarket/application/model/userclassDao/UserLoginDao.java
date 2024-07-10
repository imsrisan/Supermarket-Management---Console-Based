package supermarket.application.model.userclassDao;

import supermarket.application.controller.DbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserLoginDao {
    public boolean userLogin(String emailid, String emailpassword){
        try{
            Connection con = DbConnection.getConnection();
            Statement st = con.createStatement();
            String query = "select email from users where email = '"+emailid+"';";
            ResultSet rs = st.executeQuery(query);
            rs.next();
            String email = rs.getString(1);
            int passin = 0;
            if(email.equals(emailid)){
                passin = 1;
            }
            else{
                passin = 0;
            }
            if(passin == 1){
                String query1 = "select password from users where email = '"+emailid+"';";
                ResultSet rs1 = st.executeQuery(query1);
                rs1.next();
                String pass = rs1.getString(1);
                if(pass.equals(emailpassword)){
                    return true;
                }
                else{
                    return false;
                }
            }
            else{
                return false;
            }


        }
        catch(SQLException e)
        {
            //System.out.println(e);
            return false;
        }
    }
}
