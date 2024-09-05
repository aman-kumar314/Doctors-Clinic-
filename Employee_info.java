
package doctorsclinic;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;
import net.proteanit.sql.DbUtils;


public class Employee_info extends JFrame {
    
    Employee_info(){
        
        JPanel panel = new JPanel();
        panel.setBounds(5,5,990,590);
        panel.setBackground(new Color(186,245,243));
        panel.setLayout(null);
        add(panel);
        
        JTable table = new JTable();
        table.setBackground(new Color(109,164,170));
        table.setBounds(10,34,980,450);
        table.setFont(new Font("Tahoma",Font.BOLD,13));
        panel.add(table);
        
         try{
            ConnectionProvider c = new ConnectionProvider();
            String q = "select * from EMP_INFO";
            ResultSet rs = c.st.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
            e.printStackTrace();
        }
         
         JLabel label = new JLabel("Name");
        label.setBounds(41,9,70,20);
        label.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(label);
        
        JLabel labe2 = new JLabel("Age");
        labe2.setBounds(185,9,70,20);
        labe2.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(labe2);
        
        JLabel labe3 = new JLabel("Phone Number");
        labe3.setBounds(345,9,150,20);
        labe3.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(labe3);
        
        JLabel labe4 = new JLabel("Salary");
        labe4.setBounds(550,9,70,20);
        labe4.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(labe4);
        
        JLabel labe5 = new JLabel("Gmail");
        labe5.setBounds(730,9,70,20);
        labe5.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(labe5);
        
        JLabel labe6 = new JLabel("Adhar Number");
        labe6.setBounds(830,9,150,20);
        labe6.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(labe6);
        
         JButton b1 = new JButton("BACK");
        b1.setBounds(330,500,130,30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        panel.add(b1);
         b1.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            setVisible(false);
        }
    });
        setUndecorated(true);
        setSize(1000,600);
        setLayout(null);
        setLocation(180,90);
        setVisible(true);
        
    }
    
    public static void main(String args[]){
        new Employee_info();
    }
}
