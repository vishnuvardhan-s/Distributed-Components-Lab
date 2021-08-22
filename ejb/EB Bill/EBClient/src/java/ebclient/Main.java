/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ebclient;

import eb.EBBeanRemote;
import javax.ejb.EJB;
import java.util.*;
/**
 *
 * @author DELL
 */
public class Main {

    @EJB
    private static EBBeanRemote eBBean;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("Enter the number of units: ");
            int units = sc.nextInt();
            int amount = eBBean.calculate(units);
            System.out.println("The amount is: " + amount);
        }
    }
    
}
