import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
public class RMI_Impl extends UnicastRemoteObject implements RMI_Interface
{
    private static final long serialVersionUID = 1L;
    public RMI_Impl() throws RemoteException 
    {
        
    }
    public String print(String s)
    { 
        return "Swatika";
    }
    public int add(int a,int b) 
    {
        return a+b;
    }
}