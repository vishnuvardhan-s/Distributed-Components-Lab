public interface RMI_Interface extends java.rmi.Remote
{ 
    public String register(String patitenid, String name,String phoneNumber,int age,String entryDate, String dept, String disease, String doctor) throws java.rmi.RemoteException;
    public String search(String name) throws java.rmi.RemoteException;
}