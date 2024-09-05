
package doctorsclinic;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;


public class Update_patient_details extends JFrame {
    
    Update_patient_details(){
    
        JPanel  panel = new JPanel();
        panel.setBounds(5,5,940,490);
        panel.setBackground(new Color (186,245,243));
        panel.setLayout(null);
        add(panel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/updated.png"));
        Image image = i1.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(image);
        JLabel label = new JLabel(i2);
        label.setBounds(500,60,300,300);
        panel.add(label);
        
         JLabel label1= new JLabel("Update Patient Details");
         label1.setBounds(124,11,260,25);
         label1.setFont(new Font ("Tahoma",Font.BOLD,20));
         label1.setForeground(Color.BLACK);
         panel.add(label1);
         
         JLabel label2= new JLabel("Name");
         label2.setBounds(25,88,150,14);
         label2.setFont(new Font ("Tahoma",Font.PLAIN,14));
         label2.setForeground(Color.BLACK);
         panel.add(label2);
         
         Choice choice = new Choice();
        choice.setBounds(248,85,150,25);
        panel.add(choice);
        
        try{
            ConnectionProvider c = new ConnectionProvider();
            
            ResultSet rs = c.st.executeQuery("select * from Patient_info");
            while(rs.next()){
                choice.add(rs.getString("Name"));
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
         JLabel label3= new JLabel("Room Number");
         label3.setBounds(25,129,150,14);
         label3.setFont(new Font ("Tahoma",Font.PLAIN,14));
         label3.setForeground(Color.BLACK);
         panel.add(label3);
         
         JTextField textfieldR= new JTextField();
         textfieldR.setBounds(248,129,140,20);
         panel.add(textfieldR);
         
          JLabel label4= new JLabel("In-Time");
         label4.setBounds(25,174,150,14);
         label4.setFont(new Font ("Tahoma",Font.PLAIN,14));
         label4.setForeground(Color.BLACK);
         panel.add(label4);
         
         JTextField textfieldIntime= new JTextField();
         textfieldIntime.setBounds(248,174,140,20);
         panel.add(textfieldIntime);
         
          JLabel label5= new JLabel("Amount Paid (RS)");
         label5.setBounds(25,216,150,14);
         label5.setFont(new Font ("Tahoma",Font.PLAIN,14));
         label5.setForeground(Color.BLACK);
         panel.add(label5);
         
         JTextField textfieldAmount= new JTextField();
         textfieldAmount.setBounds(248,216,140,20);
         panel.add(textfieldAmount);
        
          JLabel label6= new JLabel("Pending Amount(RS)");
         label6.setBounds(25,261,150,14);
         label6.setFont(new Font ("Tahoma",Font.PLAIN,14));
         label6.setForeground(Color.BLACK);
         panel.add(label6);
         
         JTextField textfieldPending= new JTextField();
         textfieldPending.setBounds(248,261,140,20);
         panel.add(textfieldPending);
         
         JButton btnch = new JButton("Check");
        btnch.setBounds(281,378,89,23);
        btnch.setBackground( Color.BLACK);
        btnch.setForeground( Color.WHITE);
        panel.add(btnch);
        btnch.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            String id = choice.getSelectedItem();
            String q = "select * from patient_info where Name = '"+id+"'";
             try{
            ConnectionProvider c = new ConnectionProvider();
            ResultSet rs = c.st.executeQuery(q);
            while(rs.next()){
                textfieldR.setText(rs.getString("Room_Number"));
                 textfieldIntime.setText(rs.getString("Time"));
                  textfieldAmount.setText(rs.getString("Deposite"));
            }
            ResultSet rs1 = c.st.executeQuery("select * from room where room_no = '"+textfieldR.getText()+"'");
            while(rs1.next()){
                String price = rs1.getString("Price");
                int amountPaid = Integer.parseInt(price) - Integer.parseInt(textfieldAmount.getText());
                textfieldPending.setText(""+amountPaid);
            }
        }
        catch(Exception E){
            E.printStackTrace();
        }
        }
    });
          JButton update = new JButton("UPDATE");
        update.setBounds(56,378,100,23);
        update.setBackground(new Color(246,215,118));
        panel.add(update);
        update.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            try{
                ConnectionProvider c = new ConnectionProvider();
                String q = choice.getSelectedItem();
                String room = textfieldR.getText();
                String time = textfieldIntime.getText();
                String amount = textfieldAmount.getText();
                c.st.executeUpdate("update patient_info set Room_Number = '"+room+"',Time = '"+time+"', Deposite = '"+amount+"' where Name = '"+q+"'");
                JOptionPane.showMessageDialog(null, "Update Successfully Updated");
                setVisible(false);
            }
            catch(Exception E){
                E.printStackTrace();
            }
        }
    }); 
        
        JButton b1 = new JButton("BACK");
        b1.setBounds(168,378,89,23);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        panel.add(b1);
         b1.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            setVisible(false);
        }
    });

        
        setUndecorated(true);
        setSize(950,500);
        setLayout(null);
        setLocation(180,160);
        setVisible(true);   
    }
    
    
    public static void main(String []args){
     new Update_patient_details();   
    }
}
