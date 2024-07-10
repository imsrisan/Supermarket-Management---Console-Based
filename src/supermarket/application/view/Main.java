package supermarket.application.view;
import supermarket.application.view.entry.EntryView;

import java.util.*;
public class Main{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("WELCOME! to the SUPERMARKET - APPLICATION ");
        EntryView entry = new EntryView();
        entry.entry();
    }


}