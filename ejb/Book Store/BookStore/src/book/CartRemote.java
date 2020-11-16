/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book;

import javax.ejb.Remote;

/**
 *
 * @author DELL
 */
@Remote
public interface CartRemote {

    String addToCard(String String);

    String removeFromCart(String book);

    int bill();

    String payment();

    String pay(String number, String cvv, String date, String name);
    
}
