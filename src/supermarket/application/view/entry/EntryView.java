package supermarket.application.view.entry;
import supermarket.application.view.AdminView.AdminEntryView;
import supermarket.application.view.UserView.UserEntryView;

import java.util.Scanner;

public class EntryView {
    Scanner in = new Scanner(System.in);

    public void entry() {
        System.out.println("     ----------------  ");
        System.out.println("   |      1.Admin      |");
        System.out.println("   |      2.User       |");
        System.out.println("     -----------------  ");
        System.out.println("Enter The Following ");
        String enter = in.next();
        if (enter.equals("1")) {
            AdminEntryView admin = new AdminEntryView();
            admin.AdminEntryShow();
        }
        else if (enter.equals("2")) {
            UserEntryView user = new UserEntryView();
            user.userEntryShow();
        }
        else{
            System.out.println(" Please Enter '1' for 'Admin ID' and '2' for 'User ID' ");
            entry();
        }

    }
}



