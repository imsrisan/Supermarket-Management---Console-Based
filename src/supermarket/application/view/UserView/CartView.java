package supermarket.application.view.UserView;

import supermarket.application.controller.userclass.ProductDbController;

import java.util.Scanner;

public class CartView {
    Scanner in = new Scanner(System.in);
    public void viewcart(String email){
        System.out.println("|----------------------------|");
        System.out.println("| 1.View Cart and Purchase   |");
        System.out.println("| 2.Add More Products to cart|");
        System.out.println("|----------------------------|");
        String cart = in.nextLine();
        switch(cart){
            case "1":
                ProductDbController pdc = new ProductDbController();
                pdc.usercart(email);
                break;
            case "2":
                ProductListView plv = new ProductListView();
                plv.viewList(email);
                break;
            default:
                System.out.println("Enter 1 or 2 Following");
                viewcart(email);
                break;
        }
    }
}
