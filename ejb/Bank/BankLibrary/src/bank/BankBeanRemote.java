/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import javax.ejb.Remote;

/**
 *
 * @author DELL
 */
@Remote
public interface BankBeanRemote {

    void caller(int choice);

    void crawler(int choice, String accno);

    int getBalance(String accno);

    int deposit(String accno, int amount);

    int withdraw(String accno, int amount);
    
}
