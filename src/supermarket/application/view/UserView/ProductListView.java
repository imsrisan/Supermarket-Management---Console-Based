package supermarket.application.view.UserView;

import supermarket.application.controller.userclass.ProductDbController;
import supermarket.application.controller.userclass.ProductDepartmentController;

import java.util.Scanner;

public class ProductListView {
    Scanner in = new Scanner(System.in);
    public void viewList(String email) {
        ProductDepartmentController pdc = new ProductDepartmentController();
        System.out.println("Enter the Type of Product Do YOU need to Purchase");
        pdc.showDepartment();
        System.out.println("Enter the Following ");
        ProductDbController pdbc = new ProductDbController();
        try {
            int choice = in.nextInt();
            pdbc.showProducts(choice);
        } catch (Exception e) {
            System.out.println("Enter the valid id ");
        }
        System.out.println("Add to cart the amount of product you need to purchase");
        BillCart b = new BillCart();
        b.cartbill(email);
        //2
        // System.out.println("Successfully Added to cart");
       CartView cv = new CartView();
       cv.viewcart(email);
       PurchaseView pv = new PurchaseView();
       pv.userpurchase(email);
       System.out.println("***************************************");
       BillView bv = new BillView();
       bv.viewbills(email);
    }

}
