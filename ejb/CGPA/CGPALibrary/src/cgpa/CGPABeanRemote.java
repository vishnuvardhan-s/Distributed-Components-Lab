/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgpa;

import javax.ejb.Remote;

/**
 *
 * @author DELL
 */
@Remote
public interface CGPABeanRemote {

    double caclulate(String sub1, String sub2, String sub3, String sub4, String sub5, int credit1, int credit2, int credit3, int credit4, int credit5);
    
}
