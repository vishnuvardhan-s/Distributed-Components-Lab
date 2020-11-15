public interface RMI_Interface extends java.rmi.Remote
{ 
    public String print(String s) throws java.rmi.RemoteException;
    public int add(int a,int b) throws java.rmi.RemoteException;
}
