package supermarket.application.model.userclassDao;

import supermarket.application.controller.DbConnection;
import supermarket.application.controller.userclass.ProductDbController;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserPurchase {
    public void userpurchase(String email, int id){
        try{
            Connection con = DbConnection.getConnection();
            Statement st = con.createStatement();
            String query = "select productname, quantity, price from cart where id = "+id+" and email = '"+email+"';";
            ResultSet rs = st.executeQuery(query);
            rs.next();
            String pname= rs.getString(1);
            int quantity =rs.getInt(2);
            int price = rs.getInt(3);
//            System.out.println(pname);
//            System.out.println(quantity);
//            System.out.println(price);
            String query1 = "select proid,quantity from products where name ='"+pname+"'";
            ResultSet rs1 = st.executeQuery(query1);
            rs1.next();
            String pid= rs1.getString(1);
            //System.out.println(pid);
            if(quantity >0){
                int quantityavail = rs1.getInt(2)-quantity;
                //System.out.println(quantityavail);
                String query2 = "update products set quantity = "+ quantityavail+" where name= '"+pname+"';";
                int count = st.executeUpdate(query2);
                ProductDbController pdc = new ProductDbController();
                pdc.bill(email, pname, quantity, price);
                if(quantity > 0) {
                    String query3 = "insert into userbills (email, name, quantity, price) values ('" + email + "','" + pname + "'," + quantity + "," + price + ");";
                    int count1 = st.executeUpdate(query3);
                }
            }
            else{

            }

        }
        catch(SQLException e){

        }

    }
}
