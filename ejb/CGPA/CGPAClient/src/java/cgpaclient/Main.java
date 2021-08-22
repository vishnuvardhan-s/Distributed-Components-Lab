/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgpaclient;

import cgpa.CGPABeanRemote;
import javax.ejb.EJB;
import java.util.*;
/**
 *
 * @author DELL
 */
public class Main {

    @EJB
    private static CGPABeanRemote cGPABean;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        while(true) {
            String s1 = sc.next();
            String s2 = sc.next();
            String s3 = sc.next();
            String s4 = sc.next();
            String s5 = sc.next();
            int c1 = sc.nextInt();
            int c2 = sc.nextInt();
            int c3 = sc.nextInt();
            int c4 = sc.nextInt();
            int c5 = sc.nextInt();
            double gpa = cGPABean.caclulate(s1, s2, s3, s4, s5, c1, c2, c3, c4, c5);
            System.out.println("Your CGPA is" + gpa);
        }
    }
    
}
