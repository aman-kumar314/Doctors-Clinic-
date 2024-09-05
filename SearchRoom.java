
package doctorsclinic;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class SearchRoom extends JFrame {
    
    
     Choice choice;
    JTable table;
     
    SearchRoom(){
        
        JPanel  panel = new JPanel();
        panel.setBounds(5,5,690,490);
        panel.setBackground(new Color (186,245,243));
        panel.setLayout(null);
        add(panel);
        
         JLabel For = new JLabel("Search For Room");
        For.setBounds(250,11,186,31);
        For.setFont(new Font("Tahoma",Font.BOLD,20));
        For.setForeground(Color.BLACK);
        panel.add(For);
        
         JLabel status = new JLabel("Status");
        status.setBounds(70,70,80,20);
        status.setFont(new Font("Tahoma",Font.BOLD,14));
        status.setForeground(Color.BLACK);
        panel.add(status);
        
        choice = new Choice();
        choice.setBounds(170,70,120,20);
        choice.add("Available");
        choice.add("Occupied");
        panel.add(choice);
        
        table = new JTable();
        table.setBounds(0,187,700,210);
        table.setBackground(new Color(90,156,163));
        table.setForeground(Color.BLACK);
        panel.add(table);
        
         try{
            ConnectionProvider c = new ConnectionProvider();
            String a = "select * from room";
            ResultSet rs = c.st.executeQuery(a);
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
            e.printStackTrace();
        }
         
          JLabel Roomno = new JLabel("Room Number");
        Roomno.setBounds(23,162,150,20);
        Roomno.setFont(new Font("Tahoma",Font.BOLD,14));
        Roomno.setForeground(Color.BLACK);
        panel.add(Roomno);
        
        
         JLabel available = new JLabel("Availablity");
        available.setBounds(175,162,150,20);
        available.setFont(new Font("Tahoma",Font.BOLD,14));
        available.setForeground(Color.BLACK);
        panel.add(available);
        
         JLabel price = new JLabel("Price");
        price.setBounds(458,162,150,20);
        price.setFont(new Font("Tahoma",Font.BOLD,14));
        price.setForeground(Color.BLACK);
        panel.add(price);
        
         JLabel bed= new JLabel("Bed-Type");
        bed.setBounds(580,162,150,20);
        bed.setFont(new Font("Tahoma",Font.BOLD,14));
        bed.setForeground(Color.BLACK);
        panel.add(bed);
        
        JButton search = new JButton("Search");
        search.setBounds(200,420,120,25);
        search.setBackground(Color.BLACK);
        search.setForeground(Color.WHITE);
        panel.add(search);
        search.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
             String q = "select * from Room where Availability = '"+choice.getSelectedItem()+"'";
              try{
            ConnectionProvider c = new ConnectionProvider();
            ResultSet rs = c.st.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception E){
            E.printStackTrace();
        }
        }
    });
        
        
        JButton Back = new JButton("Back");
        Back.setBounds(380,420,180,25);
        Back.setBackground(Color.BLACK);
        Back.setForeground(Color.WHITE);
        panel.add(Back);
        Back.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            setVisible(false);
        }
    });
        setUndecorated(true);
         setSize(700,500);
        setLayout(null);
        setLocation(200,160);
        setVisible(true);
    }
    
    public static void main(String []args){
        new SearchRoom();
    }
}
