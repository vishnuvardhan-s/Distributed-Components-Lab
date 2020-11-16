/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgpa;
import java.util.*;
import javax.ejb.Stateless;

/**
 *
 * @author DELL
 */
@Stateless
public class CGPABean implements CGPABeanRemote {

    @Override
    public double caclulate(String sub1, String sub2, String sub3, String sub4, String sub5, int credit1, int credit2, int credit3, int credit4, int credit5) {
        HashMap<String,Integer> grades = new HashMap<>();
        grades.put("O",10);
        grades.put("A+",9);
        grades.put("A",8);
        grades.put("B+",7);
        grades.put("B",6);
        double numerator = 0.0;
        double denominator = 0.0;
        numerator += credit1*grades.get(sub1);
        numerator += credit2*grades.get(sub2);
        numerator += credit3*grades.get(sub3);
        numerator += credit4*grades.get(sub4);
        numerator += credit5*grades.get(sub5);
        denominator += credit1;
        denominator += credit2;
        denominator += credit3;
        denominator += credit4;
        denominator += credit5;
        double result = numerator/denominator;
        return result;
    }
    
    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
