/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book;

import javax.ejb.Stateless;
import java.util.*;
/**
 *
 * @author DELL
 */

class CreditCard {
    String sixteen;
    String cvv;
    String expiry;
    String name;
    CreditCard(String sixteen,String cvv,String expiry,String name) {
        this.sixteen = sixteen;
        this.cvv = cvv;
        this.expiry = expiry;
        this.name = name;
    }
}
@Stateless
public class Cart implements CartRemote {
    
    HashMap<String,Integer> books = new HashMap<>();
    ArrayList<CreditCard> cards = new ArrayList<>();
    ArrayList<String> cart = new ArrayList<>();
    public Cart() {
        books.put("Java",100);
        books.put("Cpp",1000);
        books.put("Blockchain", 1999);
        books.put("DCL",1022);
        books.put("Interview",1243);
        books.put("Python",1320);
        cards.add(new CreditCard("12345","123","1/2/2020","vishnu"));
        cards.add(new CreditCard("12347","124","1/3/2020","sishnu"));
        cards.add(new CreditCard("12349","126","1/4/2020","gishnu"));
        cards.add(new CreditCard("12348","127","1/5/2020","hishnu"));
        cards.add(new CreditCard("12346","128","1/6/2020","wishnu"));
    }
    
    @Override
    public String addToCard(String book) {
        cart.add(book);
        return "Added";
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public String removeFromCart(String book) {
        cart.remove(book);
        return "Removed!";
    }

    @Override
    public int bill() {
        int amount = 0;
        for(int i=0;i<cart.size();i++) {
            amount += books.get(cart.get(i));
        }
        return amount;
    }

    @Override
    public String payment() {
        
        return null;
    }

    @Override
    public String pay(String number, String cvv, String date, String name) {
        int flag = 0;
        for(int i=0;i<cards.size();i++) {
            if(cards.get(i).sixteen.equals(number) &&
               cards.get(i).cvv.equals(cvv) &&
               cards.get(i).expiry.equals(date) &&
               cards.get(i).name.equals(name)) {
                flag = 1;
                break;
            }
        }
        if(flag==1) {
            cart.clear();
            return "Successfully Completed!";
        }
        return "Payment details not found!";
    }
}
