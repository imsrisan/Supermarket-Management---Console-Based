package supermarket.application.model.adminclassDao;

import supermarket.application.controller.DbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AdminOperations {
  public String addProduct(int id){
    try{
      String query = "select proid from productdepartment where id = "+id;
      Connection con = DbConnection.getConnection();
      Statement st = con.createStatement();
      ResultSet rs = st.executeQuery(query);
      rs.next();
      String productid= rs.getString(1);
      //System.out.println(productid);
      return productid;
      //String query1 = "insert into products (name,quantity,price,proid ) values('"+
    }
    catch(SQLException e){
      e.printStackTrace();
    }
    return "";
  }
  public boolean addinDb(String productname, int quantity, int price, String pid) {
    try {
      Connection con = DbConnection.getConnection();
      Statement st = con.createStatement();
      String query = "insert into products (name, quantity, price, proid) values ('" + productname + "', " + quantity + ", " + price + ", '" + pid + "')";
      int count = st.executeUpdate(query);
      return true;
    } catch (SQLException e) {
      System.out.println(e);
      // e.printStackTrace();
      return false;
    }
  }
  public boolean updateQuantity(String name, int quantity, String proid) {
    try {
      Connection con = DbConnection.getConnection();
      Statement st = con.createStatement();
      String query = "UPDATE products SET quantity = " + quantity + " WHERE name = '" + name + "' AND proid = '" + proid + "'";
      int count = st.executeUpdate(query);
      return true;
    } catch (SQLException e) {
      System.out.println(e);
      return false;
    }
  }

  public boolean updatePrice(String name, int price, String proid) {
    try {
      Connection con = DbConnection.getConnection();
      Statement st = con.createStatement();
      String query = "UPDATE products SET price = " + price + " WHERE name = '" + name + "' AND proid = '" + proid + "'";
      int count = st.executeUpdate(query);
      return true;
    } catch (SQLException e) {
      System.out.println(e);
      return false;
    }
  }

  public void productView(String proid){
    try{
      //String query = "select proid from productdepartment where id = "+proid;
      Connection con = DbConnection.getConnection();
      Statement st = con.createStatement();
      //ResultSet rs = st.executeQuery(query);
      //rs.next();
      //String product= rs.getString(1);
      String query2 = "select * from products where proid = '"+proid+"';";
      ResultSet rs1 = st.executeQuery(query2);
      System.out.println("-------------------------------------------");
      System.out.println("NAME      QUANTITY    PRICE    P-ID");
      while(rs1.next()){
        System.out.println(rs1.getString(2)+"       "+rs1.getString(3) +"        "+rs1.getInt(4)+"     "+rs1.getString(5));
      }
      System.out.println("-------------------------------------------");
    }
    catch(SQLException e){
      System.out.println(e);
    }
  }

  public boolean deleteProduct(String name){
    try {
      Connection con = DbConnection.getConnection();
      Statement st = con.createStatement();
      //String query = "insert into products (name, quantity, price, proid) values ('" + productname + "', " + quantity + ", " + price + ", '" + pid + "')";
      String query = "DELETE from products where name = '"+name+"';";
      int count = st.executeUpdate(query);
      return true;
    } catch (SQLException e) {
      System.out.println(e);
      // e.printStackTrace();
      return false;
    }
  }



}
