package supermarket.application.view.AdminView;

import supermarket.application.controller.adminclass.OperationsDao;

import java.util.Scanner;

public class AdminOperationView {
    Scanner in = new Scanner(System.in);
    public void operationview(){
        System.out.println(" --------------------------------- ");
        System.out.println("|         1.Add - Product          |");
        System.out.println("|         2.Update - Product       |");
        System.out.println("|         3.View - Product         |");
        System.out.println("|         4.Delete - Product       |");
        System.out.println("|         5.Exit                   |");
        System.out.println(" --------------------------------- ");
        System.out.println("Enter the Following Operations");
        String op = in.nextLine();
        OperationsDao o = new OperationsDao();
        AddProductView apv = new AddProductView();
        switch (op){
            case "1":
                apv.addingdb();
                System.out.println("To Continue Enter 1 or 'Any key' to exit ");
                String sh = in.nextLine();
                if(sh.equals("1")){
                    operationview();
                }
                else{
                    System.exit(0);
                }
                break;
            case "2":
                apv.update();
                System.out.println("To Continue Enter 1 or 'Any key' to exit ");
                String sh1 = in.nextLine();
                if(sh1.equals("1")){
                    operationview();
                }
                else{
                    System.exit(0);
                }
                break;
            case "3":
                apv.view();
                System.out.println("To Continue Enter 1 or 'Any key' to exit ");
                String sh2 = in.nextLine();
                if(sh2.equals("1")){
                    operationview();
                }
                else{
                    System.exit(0);
                }
                break;
            case "4":
                apv.delete();
                System.out.println("To Continue Enter 1 or 'Any key' to exit ");
                String sh3 = in.nextLine();
                if(sh3.equals("1")){
                    operationview();
                }
                else{
                    System.exit(0);
                }
                break;
            case "5":
                System.exit(1);
            default:
                operationview();



        }

    }
}
