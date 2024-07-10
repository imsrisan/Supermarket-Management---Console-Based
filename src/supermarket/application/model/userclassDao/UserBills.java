package supermarket.application.model.userclassDao;

import supermarket.application.controller.DbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserBills {
    public void showBills(String eid){
        try{
            Connection con = DbConnection.getConnection();
            Statement st = con.createStatement();
            String query2 = "select * from userbills where email = '"+eid+"';";
            ResultSet rs1 = st.executeQuery(query2);
            System.out.println("-------------------------------------------");
            System.out.println("ProductName    QUANTITY    PRICE   ");
            while(rs1.next()){
                System.out.println("     "+rs1.getString(3)+"       "+rs1.getString(4) +"        "+rs1.getInt(5));
            }
            System.out.println("-------------------------------------------");
        }
        catch (SQLException e){
            System.out.println(e);
        }
    }
}
