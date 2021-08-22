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
@Stateless
public class DisplayBook implements DisplayBookRemote {
    
    HashMap<String,Integer> books = new HashMap<>();
    
    public DisplayBook() {
        books.put("Java",100);
        books.put("Cpp",1000);
        books.put("Blockchain", 1999);
        books.put("DCL",1022);
        books.put("Interview",1243);
        books.put("Python",1320);
    }
    
    @Override
    public String bookDetails(String book) {
        if(books.containsKey(book)) {
            return Integer.toString(books.get(book));
        }
        else {
            return "No book found!";
        }
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
