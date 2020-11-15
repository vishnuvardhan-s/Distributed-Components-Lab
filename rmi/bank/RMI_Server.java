import java.rmi.*;

public class RMI_Server {
    public static void main(String args[])
    {
        try
        {
            RMI_Impl implclass=new RMI_Impl();
            Naming.rebind("RMI_INSTANCE",implclass);
        }
        catch (Exception e)
        {
            System.out.println("Exception occured:" + e);
        }
    }
}