package supermarket.application.controller.userclass;

import supermarket.application.model.userclassDao.*;

public class UserEntryController {
    public boolean emailValidation(String emailId){
        EmailValidation ev = new EmailValidation();
        return ev.validate(emailId);
    }

    public boolean pass1(String password){
        PasswordValidation pv = new PasswordValidation();
        return pv.validatePassword(password);
    }
    public void userdetail(){
        UserRegister ur = new UserRegister();
        ur.register();
    }
    public boolean userdb(String name, String eId, String eP){
        UserDbDao udd = new UserDbDao();
        return udd.udbDao(name, eId, eP);
    }

    public boolean login(String email, String pass){
        UserLoginDao uld = new UserLoginDao();
        return uld.userLogin(email, pass);
    }


}
