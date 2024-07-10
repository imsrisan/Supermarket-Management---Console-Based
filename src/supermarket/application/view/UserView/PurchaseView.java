package supermarket.application.view.UserView;

import supermarket.application.controller.userclass.ProductDbController;

import java.util.Scanner;

public class PurchaseView {
    Scanner in = new Scanner(System.in);
    ProductDbController pdbc = new ProductDbController();
    public void userpurchase(String email){
        System.out.println("Enter the id you like to Purchase from the cart");
        try{
            int id = in.nextInt();
            pdbc.purchase(email, id);
        }
        catch(Exception e){
            System.out.println("Enter valid no");
            userpurchase(email);
        }
    }
    public void billDetails(String eid, String name, int quan, int price){
        System.out.println("****** Bill-Details *******");
        System.out.println("   Product: "+name);
        System.out.println("   Quantity: "+quan);
        System.out.println("   Price: "+price);
        System.out.println("***************************");
        System.out.println("Would you Like to Purchase More Enter 1 ");
        String m = in.next();
        switch (m){
            case "1":
                userpurchase(eid);
                break;
            default:
                break;

        }
    }

}
