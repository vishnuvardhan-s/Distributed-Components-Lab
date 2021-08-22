import java.rmi.*;
import java.time.*;
import java.util.*;
import java.rmi.server.UnicastRemoteObject;
public class RMI_Impl extends UnicastRemoteObject implements RMI_Interface
{
    private static final long serialVersionUID = 1L;
    String names[];
    public RMI_Impl() throws RemoteException 
    {
         names = new String[3];
         names[0] = "abc";
         names[1] = "def";
         names[2] = "ghi"; 
    }
    public String search(String name) throws RemoteException
    {
        int index = -1;
        for(int i=0;i<names.length;i++) 
        {
            if(names[i].equals(name))
            {
                index = i;
                break;
            }
        }
        if(index!=-1)
        {
            LocalDate date = LocalDate.now();
            LocalTime time = LocalTime.now();
            String result = date.toString() + ";" + time.toString() + ";" + "Welcome!";
            return result;
        }
        else
        {
            return "Name not found!";
        }
	}
}