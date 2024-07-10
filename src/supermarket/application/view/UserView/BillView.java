package supermarket.application.view.UserView;

import supermarket.application.controller.userclass.ProductDbController;

import java.util.Scanner;

public class BillView {
    Scanner in = new Scanner(System.in);
    public void viewbills(String mail){
        System.out.println("Would you like to see the previous bill purchases ");
        System.out.println("|-------------------|");
        System.out.println("|     1.YES         |");
        System.out.println("|     2.NO          |");
        System.out.println("|-------------------|");
        String bill = in.nextLine();
        switch (bill){
            case "1":
                ProductDbController pdc = new ProductDbController();
                pdc.viewBill(mail);
                String choise = in.nextLine();
                if(choise.equals("1")){
                    ProductListView plv = new ProductListView();
                    plv.viewList(mail);
                }
                else{
                    System.out.println("Thankyou for Visiting us");
                    System.exit(0);
                }
                break;
            case "2":
                System.out.println("Would you like to Purchase MORE Enter 1 ");
                String choice = in.nextLine();
                if(choice.equals("1")){
                    ProductListView plv = new ProductListView();
                    plv.viewList(mail);
                }
                else{
                    System.out.println("Thankyou for Visiting us");
                    System.exit(0);
                }
                break;
            default:
                System.out.println("Thankyou for Visiting us");
        }
    }
}
