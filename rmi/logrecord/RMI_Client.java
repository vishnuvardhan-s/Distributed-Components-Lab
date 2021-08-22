import java.rmi.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.border.Border;
public class RMI_Client
{
    public static void main(String[] argv)
    {
        if (argv.length !=1)
        {
            System.out.println("Usage: java RMI_Client &lt;IP addr of host running RMI Server");
            System.exit(0);
        }
        String serverName = argv[0];
        try
        {
            RMI_Interface myobj = (RMI_Interface)Naming.lookup("rmi://"+serverName+"/RMI_INSTANCE");
            Scanner sc = new Scanner(System.in);
            while(true)
            {
                System.out.println("Enter the name: ");
                String n = sc.next();
                String output = myobj.search(n);
                System.out.println(output);
            }
        }
        catch(Exception e)
        {
            System.out.println("Exception Occured " + e);
            System.exit(0);
        }
    }
}