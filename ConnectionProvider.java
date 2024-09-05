
package doctorsclinic;

import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.*;
public class ConnectionProvider {
    
    Connection con;
    Statement st;
    ResultSet rs;
    
    
    public ConnectionProvider(){
        try{
             
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/DoctorsClinic","root","rott");
             st = con.createStatement();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
 
}
