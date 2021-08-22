import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;
class Account
{
    public String name;
    public String password;
    public int balance;
    Account(String name,String password)
    {
        this.name = name;
        this.password = password;
        this.balance = 0;
    }
}
public class RMI_Impl extends UnicastRemoteObject implements RMI_Interface
{
    private static final long serialVersionUID = 1L;
    ArrayList<Account> accounts = new ArrayList<>();
    public RMI_Impl() throws RemoteException 
    {
        
    }
    public String create(String accno,String password) 
    {   
        int flag = -1;
        for(int i=0;i<accounts.size();i++) 
        {
            if(accounts.get(i).name.equals(accno)) 
            {
                flag = 361;
                break;
            }
        }
        if(flag==361) 
        {
            return "Account already exits!";
        }
        else 
        {
            accounts.add(new Account(accno,password));
            return "Account created successfully!";
        }
    }
    public String login(String accno, String password)
    {
        int flag = -1;
        for(int i=0;i<accounts.size();i++) 
        {
            if(accounts.get(i).name.equals(accno) && accounts.get(i).password.equals(password)) 
            {
                flag = 361;
                break;
            }
        }
        if(flag==361) 
        {
            return "SUCCESS";
        }
        else 
        {
            return "FAIL";
        }
    }
    public String deposit(String accno, int amount)
    {
        int flag = -1;
        for(int i=0;i<accounts.size();i++) 
        {
            if(accounts.get(i).name.equals(accno)) 
            {
                flag = i;
                break;
            }
        }
        if(flag!=-1) 
        {   
            accounts.get(flag).balance += amount;
            return "Deposit successful! Current balance: " + Integer.toString(accounts.get(flag).balance);
        }
        else 
        {
            return "No account exists!";
        }
    }
    public String withdraw(String accno, int amount) 
    {
        int flag = -1;
        for(int i=0;i<accounts.size();i++) 
        {
            if(accounts.get(i).name.equals(accno)) 
            {
                flag = i;
                break;
            }
        }
        if(flag!=-1) 
        {   
            int curBalance = accounts.get(flag).balance - amount;
            if(curBalance < 500) 
            {
                return "Transaction not allowed!";
            }
            else 
            {
                accounts.get(flag).balance -= amount;
                return "Withdraw successful! Current balance: " + Integer.toString(accounts.get(flag).balance);
            }
        }
        else 
        {
            return "No account exists!";
        }
    }
    public String balance(String accno) 
    {
        int flag = -1;
        for(int i=0;i<accounts.size();i++) 
        {
            if(accounts.get(i).name.equals(accno)) 
            {
                flag = i;
                break;
            }
        }
        if(flag!=-1) 
        {
            return "Your balance is: " + Integer.toString(accounts.get(flag).balance);
        }
        else 
        {
            return "No account exists!";
        }
    }
    public String transfer(String sender, String reciever, int amount)
    {
        int flag1 = -1, flag2 = -1;
        for(int i=0;i<accounts.size();i++) 
        {
            if(accounts.get(i).name.equals(sender))
            {
                flag1 = i;
            }
            if(accounts.get(i).name.equals(reciever))
            {
                flag2 = i;
            }
        }
        if(flag1==-1 || flag2==-1)
        {
            return "Sender/Reciever account do no exists!";
        }
        else
        {
            int curBalance = accounts.get(flag1).balance - amount;
            if(curBalance < 500) 
            {
                return "Transaction not allowed!";
            }
            else 
            {
                accounts.get(flag1).balance -= amount;
                accounts.get(flag2).balance += amount;
                return "Transfer successful! Current balance: " + Integer.toString(accounts.get(flag1).balance);
            }   
        }
    }
}