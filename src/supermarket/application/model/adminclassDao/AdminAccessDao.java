package supermarket.application.model.adminclassDao;

import supermarket.application.controller.adminclass.AdminEntryControl;

public class AdminAccessDao {
    public boolean accesspoint;
    public boolean checkadmin(int adminid, String adminEmail, String adminPass){
        int id =adminid;
        String email = adminEmail;
        String pass = adminPass;
        AdminDao dao = new AdminDao();
        if(id == dao.getId() && email.equals(dao.getEmail()) && pass.equals(dao.getPassword())){
            accesspoint = true;
        }
        else{
            accesspoint = false;
        }
        return accesspoint;
    }

}
