package supermarket.application.view.UserView;

import com.mysql.cj.log.Log;
import supermarket.application.controller.userclass.ProductDbController;
import supermarket.application.controller.userclass.ProductDepartmentController;
import supermarket.application.controller.userclass.UserEntryController;

import java.util.Scanner;

public class UserEntryView {
    Scanner in = new Scanner(System.in);

    public void userEntryShow(){
        System.out.println(" ------------------- ");
        System.out.println("|   1.User-Login     |");
        System.out.println("|   2.Register-User  |");
        System.out.println(" ------------------- ");
        System.out.println("Enter the Following ");
        String userentry = in.next();

        boolean product = false;
        if(userentry.equals("1")){
            LoginView lv = new LoginView();
            if(lv.login() == true){
                System.out.println("Login - Sucess ");
                System.out.println("***************************************************");
                System.out.println("Welcome!");
                String email = lv.getEmail();
                ProductListView plv = new ProductListView();
                plv.viewList(email);

            }
        }
        else if(userentry.equals("2")){
            int flag = 0;
            UserRegisterView urv = new UserRegisterView();
            urv.registerView();
            if(urv.registered == true){
                UserEntryController uec = new UserEntryController();
                if(uec.userdb(urv.getUsername(), urv.getEmail(), urv.getUserpass()) == true){
                    System.out.println("User Details 'Registered' - Sucessfully ");
                    userEntryShow();
                }
                else{
                    System.out.println("User Already Exist - Please Login");
                    userEntryShow();

                }
            }

        }
        else{
            System.out.println("Enter '1' to User - Login or '2' to Register-User");
            userEntryShow();
        }
    }
}
