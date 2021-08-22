public interface RMI_Interface extends java.rmi.Remote
{ 
    public String create(String accno,String password) throws java.rmi.RemoteException;
    public String login(String accno, String password) throws java.rmi.RemoteException;
    public String deposit(String accno, int amount) throws java.rmi.RemoteException;
    public String withdraw(String accno, int amount) throws java.rmi.RemoteException;
    public String balance(String accno) throws java.rmi.RemoteException;
    public String transfer(String sender, String reciever, int amount) throws java.rmi.RemoteException;
}