
package doctorsclinic;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.*;
import net.proteanit.sql.DbUtils;


public class patient_discharge extends JFrame {
    
    patient_discharge(){
        
        JPanel  panel = new JPanel();
        panel.setBounds(5,5,790,390);
        panel.setBackground(new Color (186,245,243));
        panel.setLayout(null);
        add(panel);
        
        JLabel label = new JLabel("Check-Out");
        label.setBounds(100,20,150,20);
        label.setFont(new Font("Tahoma",Font.BOLD,20));
        label.setForeground(Color.BLACK);
        panel.add(label);
        
        JLabel labe2 = new JLabel("Customer ID ");
        labe2.setBounds(30,80,150,20);
        labe2.setFont(new Font("Tahoma",Font.BOLD,14));
        labe2.setForeground(Color.BLACK);
        panel.add(labe2);
        
        Choice choice = new Choice();
        choice.setBounds(200,80,150,25);
        panel.add(choice);
        
         try{
            ConnectionProvider c = new ConnectionProvider();
            
            ResultSet rs = c.st.executeQuery("select * from Patient_info");
            while(rs.next()){
                choice.add(rs.getString("number"));
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }

        
        JLabel labe3 = new JLabel("Room Number ");
        labe3.setBounds(30,130,150,20);
        labe3.setFont(new Font("Tahoma",Font.BOLD,14));
        labe3.setForeground(Color.BLACK);
        panel.add(labe3);

        JLabel RNo = new JLabel();
        RNo.setBounds(200,130,150,20);
        RNo.setFont(new Font("Tahoma",Font.BOLD,14));
        RNo.setForeground(Color.BLACK);
        panel.add(RNo);

        JLabel labe4 = new JLabel("In-Time ");
        labe4.setBounds(30,180,150,20);
        labe4.setFont(new Font("Tahoma",Font.BOLD,14));
        labe4.setForeground(Color.BLACK);
        panel.add(labe4);

        JLabel INTime = new JLabel();
        INTime.setBounds(200,180,250,20);
        INTime.setFont(new Font("Tahoma",Font.BOLD,14));
        INTime.setForeground(Color.BLACK);
        panel.add(INTime);

         JLabel labe5 = new JLabel("Out-Time ");
        labe5.setBounds(30,230,150,20);
        labe5.setFont(new Font("Tahoma",Font.BOLD,14));
        labe5.setForeground(Color.BLACK);
        panel.add(labe5);
        
        Date date = new Date();
        
        JLabel OUTTime = new JLabel(""+date);
        OUTTime.setBounds(200,230,250,20);
        OUTTime.setFont(new Font("Tahoma",Font.BOLD,14));
        OUTTime.setForeground(Color.BLACK);
        panel.add(OUTTime);

        JButton discharge = new JButton("Discharge");
        discharge.setBounds(30,300,120,30);
        discharge.setBackground(Color.BLACK);
        discharge.setForeground(Color.WHITE);
        panel.add(discharge);
        discharge.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            ConnectionProvider c = new ConnectionProvider();
            try{
                c.st.executeUpdate("delete from patient_info where number = '"+choice.getSelectedItem()+"'");
                  c.st.executeUpdate("update room set Availability = 'Available' where Room_No = '"+RNo.getText()+"'");
                JOptionPane.showMessageDialog(null,"Update Successfully");
                setVisible(false);
            }
            catch(Exception E){
                E.printStackTrace();
            }
        }
    });
        
        
        JButton check = new JButton("check");
        check.setBounds(170,300,120,30);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        panel.add(check);
         check.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            ConnectionProvider c = new ConnectionProvider();
            try{
                 ResultSet rs = c.st.executeQuery("select * from Patient_info where number = '"+choice.getSelectedItem()+"'");
                 while(rs.next()){
                RNo.setText(rs.getString("Room_Number"));
                INTime.setText(rs.getString("Time"));
            }
            }
            catch(Exception E){
                E.printStackTrace();
            }
        }
    });
        
        JButton Back = new JButton("Back");
        Back.setBounds(300,300,120,30);
        Back.setBackground(Color.BLACK);
        Back.setForeground(Color.WHITE);
        panel.add(Back);
        Back.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            setVisible(false);
        }
    });
        
        
        setUndecorated(true);
         setSize(800,400);
        setLayout(null);
        setLocation(180,160);
        setVisible(true);
    }
    
    
    public static void main(String args[]){
     new patient_discharge();   
    }
}
