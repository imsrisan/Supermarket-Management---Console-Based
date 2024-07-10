package supermarket.application.model.userclassDao;

import supermarket.application.controller.DbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CartList {
    public void list(String email){
        try{

            Connection con = DbConnection.getConnection();
            Statement st = con.createStatement();
            String query = "select * from cart where email = '"+email+"';";
            ResultSet rs1 = st.executeQuery(query);
            System.out.println("-------------------------------------------");
            System.out.println("Id  ProName  QUANTITY  PRICE   ");
            while(rs1.next()){
                System.out.println(rs1.getInt(1)+"    "+rs1.getString(3)+"       "+rs1.getInt(4) +"        "+rs1.getInt(5));
            }
            System.out.println("-------------------------------------------");

        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
}
