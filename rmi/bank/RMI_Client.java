import java.rmi.*;
import java.util.*;
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
            Scanner sc = new Scanner(System.in);
            boolean loginFlag = false;
            while(true)
            {
                System.out.println("1. Create account\n2. Login\n3. Deposit\n4. Withdraw\n5. Balance\n6. Transfer\n7.Exit\n");
                int choice = sc.nextInt();
                if(choice==1)
                {
                    System.out.println("Enter your account number: ");
                    String accno = sc.next();
                    System.out.println("Enter your password: ");
                    String password = sc.next();
                    String output = obj.create(accno, password);
                    System.out.println(output);
                }
                else if(choice==2)
                {
                    System.out.println("Enter your account number: ");
                    String accno = sc.next();
                    System.out.println("Enter your password: ");
                    String password = sc.next();
                    String output = obj.login(accno, password);
                    if(output.equals("SUCCESS"))
                    {
                        loginFlag = true;
                    }
                }
                else if(choice==3)
                {
                    if(loginFlag==true)
                    {
                        System.out.println("Enter your account number: ");
                        String accno = sc.next();
                        System.out.println("Enter amount to deposit: ");
                        int amount = sc.nextInt();
                        String output = obj.deposit(accno, amount);
                        System.out.println(output);
                    }   
                    else
                    {
                        System.out.println("Login first!");
                    } 
                }
                else if(choice==4)
                {
                    if(loginFlag==true)
                    {
                        System.out.println("Enter your account number: ");
                        String accno = sc.next();
                        System.out.println("Enter amount to withdraw: ");
                        int amount = sc.nextInt();
                        String output = obj.withdraw(accno, amount);
                        System.out.println(output);
                    }   
                    else
                    {
                        System.out.println("Login first!");
                    } 
                }
                else if(choice==5)
                {
                    if(loginFlag==true)
                    {
                        System.out.println("Enter your account number: ");
                        String accno = sc.next();
                        String output = obj.balance(accno);
                        System.out.println(output);
                    }   
                    else
                    {
                        System.out.println("Login first!");
                    } 
                }
                else if(choice==6)
                {
                    if(loginFlag==true)
                    {
                        System.out.println("Enter your account number: ");
                        String accno1 = sc.next();
                        System.out.println("Enter your friend's number: ");
                        String accno2 = sc.next();
                        System.out.println("Enter amount to transfer: ");
                        int amount = sc.nextInt();
                        String output = obj.transfer(accno1,accno2,amount);
                        System.out.println(output);
                    }   
                    else
                    {
                        System.out.println("Login first!");
                    } 
                }
                else if(choice==7)
                {
                    break;
                }
            }
            sc.close();
        }
        catch(Exception e)
        {
            System.out.println("Exception Occured " + e);
            System.exit(0);
        }
        System.out.println("Connection successful!");
    }
}