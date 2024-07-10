package supermarket.application.model.userclassDao;

import supermarket.application.controller.DbConnection;
import supermarket.application.view.UserView.BillCart;
import supermarket.application.view.UserView.ProductListView;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductList {
    public void list(int id){
        try{

            String query = "select proid from productdepartment where id = "+id;
            Connection con = DbConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            rs.next();
            String product= rs.getString(1);
            String query2 = "select * from products where proid = '"+product+"';";
            ResultSet rs1 = st.executeQuery(query2);
            System.out.println("-------------------------------------------");
            System.out.println("NAME      QUANTITY    PRICE    P-ID");
            while(rs1.next()){
                System.out.println(rs1.getString(2)+"       "+rs1.getString(3) +"        "+rs1.getInt(4)+"     "+rs1.getString(5));
            }
            System.out.println("-------------------------------------------");

        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void cartBill(String pid, int quantity, String email){
        try{
            Connection con = DbConnection.getConnection();
            Statement st = con.createStatement();
            String query = "select name, price from products where name = '"+pid+"'";
            ResultSet rs = st.executeQuery(query);
            rs.next();
            String pname= rs.getString(1);
            if(quantity >0) {
                int price = rs.getInt(2) * quantity;
//            System.out.println(pname);
//            System.out.println(price);
//            System.out.println(email);
                String query2 = "insert into cart (email, productname, quantity, price) values ('" + email + "','" + pname + "'," + quantity + "," + price + ");";
                int count = st.executeUpdate(query2);
            }



        }
        catch(SQLException e){
            System.out.println("Enter the product name correct ");
            ProductListView plv = new ProductListView();
            plv.viewList(email);
//            BillCart bc = new BillCart();
//            bc.cartbill(email);
            //System.out.println(e);
        }

    }
    public void addToCart(String pid, String emailid){
        try{
            Connection con = DbConnection.getConnection();
            Statement st = con.createStatement();


        }
        catch(SQLException e){
            System.out.println(e);
        }
    }
}
