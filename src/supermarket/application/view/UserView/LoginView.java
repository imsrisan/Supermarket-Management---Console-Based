package supermarket.application.view.UserView;

import supermarket.application.controller.userclass.UserEntryController;

import java.util.Scanner;

public class LoginView {
    Scanner in = new Scanner(System.in);
    private String email;
    private String password;
    public boolean loginValidate(String e, String p){
        UserEntryController uec = new UserEntryController();
        if( uec.login(e, p) == true){
            return true;
        }
        else{
            System.out.println("[Invalid Id or Password]  Enter 'Any to Enter Again' or Exit '0' )" );
            String exit = in.nextLine();
            if(exit.equals("0")){
                System.exit(0);
            }
            login();
            return true;
        }
        //return false;
    }
    public boolean login(){
        System.out.println("Enter the Email - Id");
        email = in.nextLine();
        System.out.println("Enter the password");
        password = in.nextLine();
        LoginView lv = new LoginView();
        return lv.loginValidate(email, password);
    }

    public String getEmail() {
        return email;
    }
}
