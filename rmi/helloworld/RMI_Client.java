import java.rmi.*;
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
            RMI_Interface obj = (RMI_Interface)Naming.lookup("rmi://"+serverName+"/RMI_INSTANCE");
            System.out.println(obj.print("Godi"));
            System.out.println(obj.add(1,2));
        }
        catch(Exception e)
        {
            System.out.println("Exception Occured " + e);
            System.exit(0);
        }
        System.out.println("Connection successful!");
    }
}