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
public interface DisplayBookRemote {

    String bookDetails(String book);
    
}
