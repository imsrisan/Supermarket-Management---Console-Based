package supermarket.application.controller.adminclass;

import supermarket.application.model.adminclassDao.AdminAccessDao;

public class AdminEntryControl {
    public boolean adminEnters(int id, String email, String pass){
        AdminAccessDao access = new AdminAccessDao();
        if((access.checkadmin(id, email, pass) == true)){
            return true;
        }
        else{
            return false;
        }
    }

}
