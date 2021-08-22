import java.rmi.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.border.Border;
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
            RMI_Interface myobj = (RMI_Interface)Naming.lookup("rmi://"+serverName+"/RMI_INSTANCE");
            JFrame jf = new JFrame();
            jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jf.setExtendedState(JFrame.MAXIMIZED_BOTH);
            JButton search = new JButton("SEARCH");
            Label l1 = new Label("HOSPITAL MANAGEMENT SYSTEM");
            Font myFont = new Font("Times New Roman",Font.BOLD,20);
            Border border = BorderFactory.createLineBorder(new Color(255, 77, 77), 2);
            l1.setFont(myFont);
            l1.setBounds(650,120,350,40);
            search.setBounds(710,280,220,40);
            search.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) 
                {
                    try
                    {
                        JFrame jf_s = new JFrame();
                        jf_s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        jf_s.setExtendedState(JFrame.MAXIMIZED_BOTH);
                        Label center = new Label("HOSPITAL MANAGEMENT SYSTEM");
                        Label l1 = new Label("Patient name");
                        JTextField jt1 = new JTextField("");
                        JButton search_button = new JButton("SEARCH");
                        center.setFont(myFont);
                        l1.setFont(myFont);
                        jt1.setFont(myFont);
                        search_button.setFont(myFont);
                        center.setBounds(650,120,350,40);
                        l1.setBounds(650,200,180,40);
                        jt1.setBounds(850,200,220,40);
                        search_button.setBounds(700,280,220,40);
                        search_button.addActionListener(new ActionListener() 
                        {
                            public void actionPerformed(ActionEvent e)
                            {
                                try
                                {
                                    String result = myobj.search(jt1.getText());
                                    String unpack[] = result.split(",");
                                    if(unpack.length<8)
                                    {
                                        JOptionPane.showMessageDialog(null,"Not enough values!","Error",JOptionPane.ERROR_MESSAGE);
                                    }
                                    Label l1 = new Label("Patient ID: " + unpack[0]);
                                    Label l2 = new Label("Name: " + unpack[1]);
                                    Label l3 = new Label("Phone Number: " + unpack[2]);
                                    Label l4 = new Label("Age: " + unpack[3]);
                                    Label l5 = new Label("Entry date: " + unpack[4]);
                                    Label l6 = new Label("Department: " + unpack[5]);
                                    Label l7 = new Label("Disease: " + unpack[6]);
                                    Label l8 = new Label("Doctor: " + unpack[7]);
                                    l1.setFont(myFont);
                                    l2.setFont(myFont);
                                    l3.setFont(myFont);
                                    l4.setFont(myFont);
                                    l5.setFont(myFont);
                                    l6.setFont(myFont);
                                    l7.setFont(myFont);
                                    l8.setFont(myFont);
                                    l1.setBounds(650,360,220,40);
                                    l2.setBounds(650,400,220,40);
                                    l3.setBounds(650,440,220,40);
                                    l4.setBounds(650,480,220,40);
                                    l5.setBounds(650,520,220,40);
                                    l6.setBounds(650,560,220,40);
                                    l7.setBounds(650,600,220,40);
                                    l8.setBounds(650,640,220,40);
                                    jf_s.add(l1);
                                    jf_s.add(l2);
                                    jf_s.add(l3);
                                    jf_s.add(l4);
                                    jf_s.add(l5);
                                    jf_s.add(l6);
                                    jf_s.add(l7);
                                    jf_s.add(l8);
                                }
                                catch(Exception d2)
                                {
                                    System.out.println(d2);
                                }
                            }
                        });
                        jf_s.add(center);
                        jf_s.add(l1);
                        jf_s.add(jt1);
                        jf_s.add(search_button);
                        jf_s.setLayout(null);
                        jf_s.setVisible(true);
                    }
                    catch(Exception d1)
                    {
                        System.out.println(d1);
                    }
                }
            });
            jf.setBackground(new Color(255, 255, 179));
            jf.add(l1);
            jf.add(register);
            jf.add(search);
            jf.setLayout(null);
            jf.setVisible(true);
        }
        catch(Exception e)
        {
            System.out.println("Exception Occured " + e);
            System.exit(0);
        }
        System.out.println("Connection successful!");
    }
}