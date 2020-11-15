import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;
class Patient
{
    String patientid;
    String name;
    String phoneNumber;
    int age;
    String entryDate;
    String dept;
    String disease;
    String doctor;
    Patient(String patitenid, String name,String phoneNumber,int age,String entryDate,String dept,String disease, String doctor)
    {
        this.patientid = patitenid;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.entryDate = entryDate;
        this.dept = dept;
        this.disease = disease;
        this.doctor = doctor;
    }
    public String toString()
    {
        return this.patientid + "," + this.name + "," + this.phoneNumber + "," + this.age + "," + this.entryDate + "," + this.dept + "," + this.disease + "," + this.doctor;
    }
}
public class RMI_Impl extends UnicastRemoteObject implements RMI_Interface
{
    private static final long serialVersionUID = 1L;
    ArrayList<Patient> patients = new ArrayList<>();
    public RMI_Impl() throws RemoteException 
    {
        
    }
    public String register(String patitenid, String name,String phoneNumber,int age,String entryDate,String dept,String disease, String doctor)
    {
        Patient p = new Patient(patitenid,name,phoneNumber,age,entryDate,dept,disease,doctor);
        patients.add(p);
        return "SUCCESS";
    }
    public String search(String name)
    {
        for(int i=0;i<patients.size();i++)
        {
            if(patients.get(i).name.equals(name))
            {
                return patients.get(i).toString();
            }
        }
        return "NOT FOUND";
    }
}