
package doctorsclinic;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class Department extends JFrame{
    
    Department(){
        
        JPanel panel = new JPanel();
        panel.setBounds(5,5,690,490);
        panel.setLayout(null);
        panel.setBackground(new Color(186,245,243));
        add(panel);
        
        JTable table = new JTable();
        table.setBounds(0,40,690,300);
        table.setBackground(new Color(90,156,163));
        table.setFont(new Font("Tahoma", Font.BOLD,15));
        panel.add(table);
        
        try{
            ConnectionProvider c = new ConnectionProvider();
            String q = "select * from department";
            ResultSet rs = c.st.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        JLabel label = new JLabel("Department");
        label.setBounds(145,11,105,20);
        label.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(label);
        
         JLabel label1 = new JLabel("Phone_Number");
        label1.setBounds(430,11,135,20);
        label1.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(label1);
        
        JButton b1 = new JButton("BACK");
        b1.setBounds(400,400,130,30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        panel.add(b1);
         b1.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            setVisible(false);
        }
    });
        
        setUndecorated(true);
        setSize(700,490);
        setLayout(null);
        setLocation(200,190);
        setVisible(true);
    }
    
    public static void  main (String args[]){
        new Department();
    }
}
