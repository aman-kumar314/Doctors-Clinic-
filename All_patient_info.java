
package doctorsclinic;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class All_patient_info extends JFrame{
    
    All_patient_info(){
        
        JPanel panel = new JPanel();
        panel.setBounds(5,5,890,590);
        panel.setLayout(null);
        panel.setBackground(new Color(186,245,243));
        add(panel);
        
        JTable table = new JTable();
        table.setBounds(10,40,860,400);
        table.setBackground(new Color(90,156,163));
        table.setFont(new Font("Tahoma", Font.BOLD,13));
        panel.add(table);
        
        try{
            ConnectionProvider c = new ConnectionProvider();
            String q = "select * from patient_info";
            ResultSet rs = c.st.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        JLabel label1 = new JLabel("ID");
        label1.setBounds(31,11,100,14);
        label1.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label1);
        
        JLabel label2 = new JLabel("Number");
        label2.setBounds(150,11,100,14);
        label2.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label2);
        
        JLabel label3 = new JLabel("Name");
        label3.setBounds(270,11,100,14);
        label3.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label3);
        
        JLabel label4 = new JLabel("Gender");
        label4.setBounds(360,11,100,14);
        label4.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label4);
        
        JLabel label5 = new JLabel("Disease");
        label5.setBounds(480,11,100,14);
        label5.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label5);
        
        JLabel label6 = new JLabel("Room");
        label6.setBounds(600,11,100,14);
        label6.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label6);
        
        JLabel label7 = new JLabel("Time");
        label7.setBounds(680,11,100,14);
        label7.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label7);
        
        JLabel label8 = new JLabel("Deposite");
        label8.setBounds(780,11,100,14);
        label8.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label8);
        
        JButton b1 = new JButton("BACK");
        b1.setBounds(450,515,130,30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        panel.add(b1);
         b1.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            setVisible(false);
        }
    });
        setUndecorated(true);
        setSize(900,600);
        setLayout(null);
        setLocation(190,90);
        setVisible(true);
    }
    
    
    public static void main(String args[]){
        new All_patient_info();
    }
}
