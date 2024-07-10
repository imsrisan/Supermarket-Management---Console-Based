package supermarket.application.model.userclassDao;

import supermarket.application.controller.DbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductDepartmentDao {
    public void showdb(){
        try {
            String query = "Select * from productdepartment";
            Connection con = DbConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            System.out.println("------------------------");
            while(rs.next()){

                System.out.println(+rs.getInt(1) + ". "+ rs.getString(2));

            }
            System.out.println("------------------------");
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
