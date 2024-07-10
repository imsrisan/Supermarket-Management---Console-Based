package supermarket.application.controller.adminclass;

import supermarket.application.model.adminclassDao.AdminOperations;
import supermarket.application.model.adminclassDao.ProductList;

public class OperationsDao {
    AdminOperations ao = new AdminOperations();

    public void list(){
        ProductList pl = new ProductList();
        pl.productList();
    }
    public String addProduct(int i){
        return ao.addProduct(i);
    }

    public boolean addinDb(String name, int q, int p, String pid){
        return ao.addinDb(name,q,p,pid);

    }

    public boolean updateQuantity(String name, int q, String pid){
        return ao.updateQuantity(name, q, pid);
    }

    public boolean updatePrice(String name, int p, String pid){
        return ao.updatePrice(name, p, pid);
    }

    public void view(String eid){
        ao.productView(eid);
    }

    public boolean delete(String name){
        return ao.deleteProduct(name);
    }




}
