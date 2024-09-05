
package doctorsclinic;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;
import doctorsclinic.ConnectionProvider;

public class Login extends JFrame implements ActionListener {
    
    JTextField textField;
    JPasswordField JPasswordfield;
    JButton b1,b2;
  
    
    Login(){
        
        JLabel namelabel = new JLabel("Username");
        namelabel.setBounds(40,20,100,30);
        namelabel.setFont(new Font("Tahoma",Font.BOLD,16));
        namelabel.setForeground(Color.BLACK);
        add(namelabel);
        
        JLabel Password = new JLabel("Password");
        Password.setBounds(40,80,100,30);
        Password.setFont(new Font("Tahoma",Font.BOLD,16));
        Password.setForeground(Color.BLACK);
        add(Password);
        
        textField = new JTextField();
        textField.setBounds(150,20,150,30);
        textField.setFont(new Font ("Tahoma",Font.PLAIN,15));
        textField.setBackground(new Color(247,250,250));
        add(textField);
        
        JPasswordfield = new JPasswordField();
        JPasswordfield.setBounds(150,80,150,30);
        JPasswordfield.setFont(new Font("Tahoma",Font.PLAIN,15));
        JPasswordfield.setBackground(new Color(247,250,250));
        add(JPasswordfield);
        
        ImageIcon imageicon = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i1 = imageicon.getImage().getScaledInstance(250,210,Image.SCALE_DEFAULT);
        ImageIcon imageicon1 = new ImageIcon(i1);
        JLabel label = new  JLabel(imageicon1);
        label.setBounds(300,-30,400,300);
        add(label);
        
        b1 = new JButton("Login ");
        b1.setBounds(40,150,120,30);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Cancel");
        b2.setBounds(180,150,120,30);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        add(b2);
        
        
        getContentPane().setBackground(new Color(186, 245, 243));
        setSize(750,300);
        setLocation(300,200);
        setLayout(null);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource() == b1){
            try{
                ConnectionProvider c = new ConnectionProvider();
                String user = textField.getText();
                String Pass = JPasswordfield.getText();
                
                String q = "select *from Login where Id = '"+user+"' and Password = '"+Pass+"'  ";
                ResultSet rs = c.st.executeQuery(q);
                
                if(rs.next()){
                    new Reception();
                    setVisible(false);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Invalid User");
                }
                
                
                
            }
            catch(Exception E){
                E.printStackTrace();
            }
        }
        else{
         System.exit(40);
        }
    }
    
    public static void main(String args[]){
        new Login();
    }
}
