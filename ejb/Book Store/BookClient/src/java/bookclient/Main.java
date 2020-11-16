/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookclient;
import book.CartRemote;
import book.DisplayBookRemote;
import java.util.*;
import javax.ejb.EJB;
/**
 *
 * @author DELL
 */
public class Main {

    @EJB
    private static DisplayBookRemote displayBook;

    @EJB
    private static CartRemote cart;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        String book,output;
        while(true) {
            System.out.println("Enter your choice: \n1. Search book\n2. Add to cart\n3. Remove from cart\n4. Bill\n5. Pay");
            int choice = sc.nextInt();
            switch(choice) {
                    case 1:
                        System.out.println("Enter book name: ");
                        book = sc.next();
                        output = displayBook.bookDetails(book);
                        System.out.println("Book found: " + book + ": " + output);
                        break;
                    case 2:
                        System.out.println("Enter book name: ");
                        book = sc.next();
                        output = cart.addToCard(book);
                        System.out.println(output);
                        break;
                    case 3:
                        System.out.println("Enter book name: ");
                        book = sc.next();
                        output = cart.removeFromCart(book);
                        System.out.println(output);
                        break;
                    case 4:
                        System.out.println("The biil is: " + cart.bill());
                        break;
                    case 5:
                        String number = sc.next();
                        String cvv = sc.next();
                        String expiry = sc.next();
                        String name = sc.next();
                        output = cart.pay(number, cvv, expiry, name);
                        System.out.println(output);
                        break;
                    default:
                        break;
            }
        }
    }
    
}
