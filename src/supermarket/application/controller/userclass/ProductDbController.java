package supermarket.application.controller.userclass;

import supermarket.application.model.userclassDao.CartList;
import supermarket.application.model.userclassDao.ProductList;
import supermarket.application.model.userclassDao.UserBills;
import supermarket.application.model.userclassDao.UserPurchase;
import supermarket.application.view.UserView.PurchaseView;

public class ProductDbController {
    ProductList list = new ProductList();
    public void showProducts(int c){
        list.list(c);
    }

    public void billCart(String proId, int quan, String e){
        list.cartBill(proId, quan, e);
    }
    public void cart(String id, String email){
        list.addToCart(id, email);
    }
    public void usercart(String emid){
        CartList cl = new CartList();
        cl.list(emid);
    }
    public void purchase(String email,int id){
        UserPurchase up = new UserPurchase();
        up.userpurchase(email, id);
    }
    public void bill(String email, String name, int q, int p){
        PurchaseView pv = new PurchaseView();
        pv.billDetails(email, name, q, p);
    }
    public void viewBill(String e){
        UserBills ub = new UserBills();
        ub.showBills(e);
    }

}
