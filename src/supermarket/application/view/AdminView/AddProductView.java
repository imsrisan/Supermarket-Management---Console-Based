package supermarket.application.view.AdminView;

import supermarket.application.controller.adminclass.OperationsDao;
import supermarket.application.model.adminclassDao.AdminOperations;

import java.sql.SQLException;
import java.util.Scanner;

public class AddProductView {
    AdminOperations a = new AdminOperations();
    OperationsDao o = new OperationsDao();
    Scanner in = new Scanner(System.in);
    public String addView(){
        o.list();
        System.out.println("In which DEPARTMENT youre adding product enter the id");
        try{
            int id = in.nextInt();
            //System.out.println(o.addProduct(id));
            return o.addProduct(id);

        }
        catch(Exception e){
            System.out.println("Something Wrong Enter Again");
            addView();
        }
        addingdb();
        return "";
    }
    public void addingdb() {
        AddProductView a1 = new AddProductView();
        String pid = a1.addView();
        //System.out.println(pid);
        System.out.println("Enter the Product-Name");
        String productName = in.nextLine();
        System.out.println("Enter the Quantity");
        int quantity = 0;
        try {
            quantity = in.nextInt();
        } catch (Exception e) {
            System.out.println("Enter the Quantity in  number");
            quantity = in.nextInt();
        }
        System.out.println("Enter the Price of the Product");
        int price = 0;
        try {
            price = in.nextInt();
        } catch (Exception e) {
            System.out.println("Enter the Price in  number");
            price = in.nextInt();
        }
        if(o.addinDb(productName, quantity, price, pid)== true){
            System.out.println("Product Added Sucessfully");
        }
        else{
            addingdb();
        }
    }
    public void update(){
        AddProductView a2 = new AddProductView();
        String pid =a2.addView();
        System.out.println("|------------------------|");
        System.out.println("|       1.quantity       |");
        System.out.println("|       2.price          |");
        System.out.println("|------------------------|");
        System.out.println("Enter the Choice");
        String ch = in.nextLine();
        switch (ch){
            case "1":
                System.out.println("Enter the Product-Name");
                String pname = in.nextLine();
                System.out.println("Enter the Quantity you need to Update");
                int q=0;
                try{
                    q = in.nextInt();
                }
                catch(Exception e){
                    System.out.println("Enter the Quantity in number");
                    update();
                }
                if(o.updateQuantity(pname, q, pid)==true){
                    System.out.println("Update Sucessfull");
                }
                else{
                    System.out.println("Product name Something went wrong");
                    update();
                }
                break;
            case "2":
                System.out.println("Enter the Product-Name");
                String pn = in.nextLine();
                System.out.println("Enter the Price you need to Update");
                int p=0;
                try{
                    p = in.nextInt();
                }
                catch(Exception e){
                    System.out.println("Enter the Price in number");
                    update();
                }
                if(o.updatePrice(pn, p, pid)==true){
                    System.out.println("Update Sucessfull");
                }
                else{
                    System.out.println("Product name Something went wrong");
                    update();
                }
                break;
            default:
                update();
        }

    }
    public String aView(){
        o.list();
        System.out.println("In which DEPARTMENT You want to view the product enter the id");
        try{
            int id = in.nextInt();
            //System.out.println(o.addProduct(id));
            return o.addProduct(id);

        }
        catch(Exception e){
            System.out.println("Something Wrong Enter Again");
            addView();
        }
        return "";
    }
    public void view(){
        AddProductView a3 = new AddProductView();
        String produid = a3.aView();
        o.view(produid);
    }
    public String dView(){
        o.list();
        System.out.println("In which DEPARTMENT You want to DELETE the product enter the id");
        try{
            int id = in.nextInt();
            return o.addProduct(id);

        }
        catch(Exception e){
            System.out.println("Something Wrong Enter Again");
            addView();
        }
        return "";
    }
    public void delete(){
        AddProductView a4 = new AddProductView();
        String ppid = a4.dView();
        System.out.println("Enter the Product-Name you want to delete");
        String productName = in.nextLine();
        if(o.delete(productName) == true){
            System.out.println("Product Deleted Sucessfully");
        }
        else{
            delete();
        }
    }


}

