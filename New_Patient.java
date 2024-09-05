
package doctorsclinic;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.util.Date;
import javax.swing.*;
import java.awt.*;
import java.sql.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 public class New_Patient extends JFrame implements ActionListener {
    
     JComboBox comboBox;
     
     JTextField textfieldNumber, textName,textFieldDisease, textfieldDeposite;
     
     JRadioButton r1 , r2;
     
     Choice c1;
     
     JLabel date;
     
     JButton b1 ,b2;
     
     New_Patient(){
         
         JPanel panel = new JPanel();
         panel.setBounds(5,5,840,540);
         panel.setBackground(new Color(186, 245, 243));
         panel.setLayout(null);
         add(panel);
         
         ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/patient.png"));
         Image image = imageIcon.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
         ImageIcon imageIcon1 = new ImageIcon(image);
         JLabel label = new JLabel(imageIcon1);
         label.setBounds(550,150,200,200);
         panel.add(label);
         
         JLabel labelName = new JLabel("NEW PATIENT FORM");
         labelName.setBounds(115,10,260,50);
         labelName.setFont(new Font ("Tahoma",Font.BOLD,20));
         panel.add(labelName);
         
          JLabel labelID= new JLabel("ID");
         labelID.setBounds(35,76,200,14);
         labelID.setFont(new Font ("Tahoma",Font.BOLD,14));
         labelID.setForeground(Color.BLACK);
         panel.add(labelID);
         
         comboBox = new JComboBox(new String []{"Adhar Card", "Voter ID", "Driving Licence"});
         comboBox.setBounds(270,73,150,20);
         comboBox.setBackground(new Color(3,45,48) );
         comboBox.setForeground(Color.WHITE);
         comboBox.setFont(new Font("Tahoma", Font.BOLD,14));
         panel.add(comboBox);
         
         JLabel labelNumber= new JLabel("Number");
         labelNumber.setBounds(35,111,200,14);
         labelNumber.setFont(new Font ("Tahoma",Font.BOLD,14));
         labelNumber.setForeground(Color.BLACK);
         panel.add(labelNumber);
         
         textfieldNumber = new JTextField();
         textfieldNumber.setBounds(270,111,150,20);
         panel.add(textfieldNumber);
         
         JLabel labelName1= new JLabel("Name");
         labelName1.setBounds(35,150,200,14);
         labelName1.setFont(new Font ("Tahoma",Font.BOLD,14));
         labelName1.setForeground(Color.BLACK);
         panel.add(labelName1);
         
         textName= new JTextField();
         textName.setBounds(270,151,150,20);
         panel.add(textName);
         
          JLabel labelGender= new JLabel("Gender");
         labelGender.setBounds(35,190,200,14);
         labelGender.setFont(new Font ("Tahoma",Font.BOLD,14));
         labelGender.setForeground(Color.BLACK);
         panel.add(labelGender);
         
         r1 = new JRadioButton("Male");
         r1.setFont(new Font("Tahoma",Font.BOLD,12));
         r1.setForeground(Color.BLACK);
         r1.setBackground(new Color(109,164,170));
         r1.setBounds(270,190,80,12);
         panel.add(r1);
         
         r2 = new JRadioButton("Female");
         r2.setFont(new Font("Tahoma",Font.BOLD,12));
         r2.setForeground(Color.BLACK);
         r2.setBackground(new Color(109,164,170));
         r2.setBounds(350,190,80,12);
         panel.add(r2);
         
         JLabel labelDisease= new JLabel("Disease");
         labelDisease.setBounds(35,230,200,14);
         labelDisease.setFont(new Font ("Tahoma",Font.BOLD,14));
         labelDisease.setForeground(Color.BLACK);
         panel.add(labelDisease);
         
         textFieldDisease= new JTextField();
         textFieldDisease.setBounds(270,230,150,20);
         panel.add(textFieldDisease);

        JLabel labelRoom= new JLabel("Room");
         labelRoom.setBounds(35,273,200,14);
         labelRoom.setFont(new Font ("Tahoma",Font.BOLD,14));
         labelRoom.setForeground(Color.BLACK);
         panel.add(labelRoom);
         
          //Room cjoice      
          
          c1 = new Choice();
          try{
              ConnectionProvider  c = new ConnectionProvider();
              ResultSet rs = c.st.executeQuery("select * from Room");
              while(rs.next()){
              c1.add(rs.getString("room_no"));
          }
          }
          catch(Exception e){
              e.printStackTrace();
          }
          
          c1.setBounds(270,274,150,20);
          c1.setFont(new Font("Tahoma ",Font.BOLD,14));
          c1.setForeground(Color.BLACK);
          setBackground(new Color(3,45,48));
          panel.add(c1);

         JLabel labelDate= new JLabel("Time");
         labelDate.setBounds(35,315,200,14);
         labelDate.setFont(new Font ("Tahoma",Font.BOLD,14));
         labelDate.setForeground(Color.BLACK);
         panel.add(labelDate);
        
         
         Date date1 = new Date();
         
         date = new JLabel("_"+date1);
         date.setBounds(265,315,250,14);
         date.setForeground(Color.BLACK);
         date.setFont(new Font ("Tahoma",Font.BOLD,14));
         panel.add(date);
         
         JLabel labelDeposite= new JLabel("Deposite");
         labelDeposite.setBounds(35,358,200,17);
         labelDeposite.setFont(new Font ("Tahoma",Font.BOLD,14));
         labelDeposite.setForeground(Color.BLACK);
         panel.add(labelDeposite);
         
         textfieldDeposite= new JTextField();
         textfieldDeposite.setBounds(270,358,150,20);
         panel.add(textfieldDeposite);
         
         b1 = new JButton("ADD");
         b1.setBounds(100,430,120,30);
         b1.setForeground(Color.WHITE);
         b1.setBackground(Color.BLACK);
         b1.addActionListener(this);
         panel.add(b1);

         b2 = new JButton("BACK");
         b2.setBounds(260,430,120,30);
         b2.setForeground(Color.WHITE);
         b2.setBackground(Color.BLACK);
         b2.addActionListener(this);
         panel.add(b2);

         
         setUndecorated(true);
         setSize(850,550);
         setLayout(null);
         setLocation(200,150);
         setVisible(true);
         
     }
     
     public void actionPerformed(ActionEvent e){
         if(e.getSource() == b1){
             ConnectionProvider c = new ConnectionProvider();
             String radioBTN = null;
             if(r1.isSelected()){
                 radioBTN = "Male";
                 
             }else if(r2.isSelected()){
                 radioBTN = "Female";
             }
             
             String s1 = (String)comboBox.getSelectedItem();
             String s2 = textfieldNumber.getText();
             String s3 = textName.getText();
             String s4 = radioBTN;
             String s5 = textFieldDisease.getText();
             String s6 = c1.getSelectedItem();
             String s7 = date.getText();
             String s8 = textfieldDeposite.getText();
             
             
             try{
                String q = "insert into patient_info values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"','"+s8+"')";
                String q1 = "update room set Availability = 'Occupied' where room_no = "+s6;
                c.st.executeUpdate(q);
                c.st.executeUpdate(q1);
                JOptionPane.showMessageDialog(null,"Added Successfully");
                setVisible(false);
             }
             catch(Exception E){
                 E.printStackTrace();
             }
             
             
         }
         else{
             setVisible(false);
         }
     }
     public static void main(String args[]){
         new New_Patient();
     }
}
