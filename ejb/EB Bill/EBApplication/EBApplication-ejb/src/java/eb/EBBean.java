/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eb;

import javax.ejb.Stateless;

/**
 *
 * @author DELL
 */
@Stateless
public class EBBean implements EBBeanRemote {

    @Override
    public int calculate(int units) {
        if (units<=100) {  
            return units*50;  
        }  
        else if (units<=200) {  
            return (100*50)+(units-100)*100;  
        }  
        else if (units<=300) {  
            return (100*50)+(100*100)+(units - 200)*200;  
        }  
        else if (units>300) {  
            return (100*50)+(100*100)+(100*200)+(units-300)*300;  
        }
        return 0;
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
