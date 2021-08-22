/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankclient;

import bank.BankBeanRemote;
import javax.ejb.EJB;
import java.awt.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.border.Border;
/**
 *
 * @author DELL
 */
public class Main {

    @EJB
    private static BankBeanRemote bankBean;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JFrame jf = new JFrame();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setExtendedState(JFrame.MAXIMIZED_BOTH);
        Label l1 = new Label("HOSPITAL MANAGEMENT SYSTEM");
        Font myFont = new Font("Times New Roman",Font.BOLD,20);
        Border border = BorderFactory.createLineBorder(new Color(255, 77, 77), 2);
        l1.setFont(myFont);
        l1.setBounds(650,120,350,40);
        jf.add(l1);
        jf.setLayout(null);
        jf.setVisible(true);
        System.out.println(bankBean.getBalance("rag"));
        System.out.println(bankBean.deposit("rag",30));
        System.out.println(bankBean.withdraw("rag",50));
    }
}
