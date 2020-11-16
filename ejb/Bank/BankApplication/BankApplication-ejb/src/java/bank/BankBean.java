/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import javax.ejb.Stateless;
import java.util.*;
/**
 *
 * @author DELL
 */
@Stateless
public class BankBean implements BankBeanRemote {
    HashMap<String,Integer> accounts;
    public BankBean() {
        accounts = new HashMap<String,Integer>();
        accounts.put("rag",600);
        accounts.put("viniths",500);
        accounts.put("aish",1000);
    };
    @Override
    public void caller(int choice) {
        if(choice==1) {
            
        }
        else if(choice==2) {
            
        }
        else if(choice==3) {
            
        }
    }
 
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void crawler(int choice, String accno) {
        if(choice==1) {
            System.out.println(accounts.get(accno));
        }
        else if(choice==2) {
            accounts.put(accno,accounts.get(accno)+14);
        }
        else if(choice==3) {
            accounts.put(accno,accounts.get(accno)-14);
        }
    }

    @Override
    public int getBalance(String accno) {
        return accounts.get(accno);
    }

    @Override
    public int deposit(String accno, int amount) {
        accounts.put(accno,accounts.get(accno)+amount);
        return accounts.get(accno);
    }

    @Override
    public int withdraw(String accno, int amount) {
        accounts.put(accno,accounts.get(accno)-amount);
        return accounts.get(accno);
    }
    
}
