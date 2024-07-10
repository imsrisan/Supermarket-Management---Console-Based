package supermarket.application.controller.userclass;

import supermarket.application.model.userclassDao.ProductDepartmentDao;

public class ProductDepartmentController {
    public void showDepartment(){
        ProductDepartmentDao pdd = new ProductDepartmentDao();
        pdd.showdb();
    }
}
