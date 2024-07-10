package supermarket.application.view.UserView;

import supermarket.application.controller.userclass.UserEntryController;

import java.util.Scanner;

public class UserRegisterView {
    Scanner in = new Scanner(System.in);
    UserEntryController uec = new UserEntryController();
    private String username;
    private String email;
    private String userpass;
    boolean registered = false;
    public void pass(){
        System.out.println("Enter the Password which contains more than 6 character 1 upper and 1 specail and 2 number");
        userpass = in.nextLine();
        if(uec.pass1(userpass) == false){
            System.out.println("Not Strong Password Enter again 'Any' or Exit '1 key'");
            String aa = in.nextLine();
            if(aa.equals("1")){
                System.exit(0);
            }
            else{
                pass();
            }
        }
        registered = true;
    }
    public void emailPass(){
        System.out.println("Enter the ' Email-Id '");
        email = in.nextLine();
        if(uec.emailValidation(email) == false){
            System.out.println("EmailId - Invalid Enter Again 'Any' or Exit 'Any key '1'");
            String a = in.nextLine();
            if(a.equals("1")){
                System.exit(0);
            }
            else{
                emailPass();
            }

        }
        else{
            registered = true;
            pass();
        }
    }
    public void registerView(){
        System.out.println("Register - Form");
        System.out.println("Enter the ' Username '");
        username = in.nextLine();
        if(username.equals("")){
            registerView();
        }
        registered = true;
        emailPass();
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getUserpass() {
        return userpass;
    }
}
