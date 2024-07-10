package supermarket.application.view.UserView;

import supermarket.application.controller.userclass.ProductDbController;
import supermarket.application.controller.userclass.UserEntryController;

import java.util.Scanner;

public class BillCart {
    Scanner in = new Scanner(System.in);
    public void cartbill(String eid){
        System.out.println("Enter the name of the product");
        String pname = in.nextLine();
        System.out.println("Enter the Quantity");
        int q = 0;
        try{
            q = in.nextInt();
        }
        catch(Exception e){
            System.out.println("Enter the Quantity in number");
        }
        ProductDbController pdc = new ProductDbController();
        pdc.billCart(pname, q,eid);

    }
}
