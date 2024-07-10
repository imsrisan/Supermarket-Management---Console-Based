package supermarket.application.view.AdminView;

import supermarket.application.controller.adminclass.AdminEntryControl;
import supermarket.application.view.entry.EntryView;

import java.util.Scanner;

public class AdminEntryView {
    Scanner in = new Scanner(System.in);
    public void AdminEntryShow(){
        System.out.println("--- ADMIN LOGIN ---  ");
        System.out.println("Enter the ID BOSS - ");
        int bossId = 0;
        String bossemail;
        String bosspassword;
        try {
            bossId = in.nextInt();
        }
        catch (Exception e){
            System.out.println("Id is a Number 'Terminated' 'Try - Again'");
            EntryView ev = new EntryView();
            ev.entry();
            System.exit(0);
        }
            in.nextLine();
            System.out.println("Enter the EMAIL-ID BOSS - ");
            bossemail = in.nextLine();
            System.out.println("Enter the PASSWORD BOSS ");
            bosspassword = in.nextLine();
            AdminEntryControl adminController = new AdminEntryControl();
            if (adminController.adminEnters(bossId, bossemail, bosspassword) == true) {
                System.out.println("Login - SuccesFull ");
                AdminOperationView aov = new AdminOperationView();
                aov.operationview();
            } else {
                System.out.println("Access - Denied Wrong Details ");
                System.out.println(" --------------------------------------------------------------- ");
                System.out.println("|   Login again '1' OR Back to Previous Page '2' or Exit 'ANY'  |");
                System.out.println(" --------------------------------------------------------------- ");
                try {
                    int exit = in.nextInt();
                    if (exit == 1) {
                        AdminEntryShow();
                    } else if (exit == 2) {
                        EntryView ev = new EntryView();
                        ev.entry();
                    }
                } catch (Exception e) {
                    System.exit(0);
                }

            }

    }
}
