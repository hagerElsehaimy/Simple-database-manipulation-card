/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hagar
 */
public class Con 
{
    private static Connection con;
    private static PreparedStatement pst;
    private static ResultSet rs;
    
 //   Person myP = myPersons.get(myPersons.size()-1); 

    
    public Con()
    {
       try{  
                Class.forName("com.mysql.jdbc.Driver");
//                DriverManager.registerDriver(new org.git.mm.mysql.Driver());
                con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Person","root",""); 
                //here sonoo is database name, root is username and password  
                //Statement stmt=con.createStatement();  
                //ResultSet rs=stmt.executeQuery("select * from emp");  
            }
        catch(Exception e)
            { 
                //System.out.println(e);
                e.printStackTrace();
            }
    }

    
    public static boolean Insertp(Person myP){
   
            boolean flag = false;
            try
            {
                    pst = con.prepareStatement("INSERT INTO Person_Details VALUES (?,?,?,?,?)");
                    pst.setString(1,myP.getFirstName());
                    pst.setString(2,myP.getMiddleName());
                    pst.setString(3,myP.getLastName());
                    pst.setString(4,myP.getEmail());
                    pst.setString(5,myP.getPhone()); 
                    pst.execute();
                    flag=true;         
             
            }
        
            catch(Exception e)
            {
               System.out.println("Failed");
            }
       
    return flag;
    }

    
     public static boolean Update(String id,Person newData)
    {
        boolean updated=false;
        try 
        {
            pst = con.prepareStatement("UPDATE Person_Details SET  First_Name = ?, Middle_Name = ?, Last_Name = ?, Email = ?, Phone = ? WHERE ID = ?");
            pst.setString(1,newData.getFirstName());
            pst.setString(2,newData.getMiddleName());
            pst.setString(3,newData.getLastName());
            pst.setString(4,newData.getEmail());
            pst.setString(5,newData.getPhone());
            pst.setString(6, id);
            pst.executeUpdate();
            updated=true;
        }
        
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
      return updated;
    }

     
    public static boolean delete(String id)
    {
        boolean flag=false;
        try
        {
            pst = con.prepareStatement("Delete from Person_Details WHERE ID = ?");
            pst.setString(1,id);
            pst.executeUpdate();
            flag=true;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return flag;
    }
    
    
    public static ArrayList<Person> getall(){
   
    ArrayList<Person> myPList = new ArrayList();
     
    String sql = "SELECT * FROM Person_Details;";
        try
        {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery(sql);
            
            while(rs.next())
            {
                //Retrieve by column name
                Person myP = new Person();
                myP.setId(rs.getString("ID"));
                myP.setFirstName(rs.getString("First_Name"));
                myP.setMiddleName(rs.getString("Middle_Name"));
                myP.setLastName(rs.getString("Last_Name"));
                myP.setEmail(rs.getString("Email"));
                myP.setPhone(rs.getString("Phone"));

                myPList.add(myP);

            }
        } 
        catch (Exception ex)
        {
           System.out.println("failed");
        }
    return myPList;
    } 
     
    
    public static void disconnect()
    {
        try {
            pst.close();
            con.close();

        } catch (SQLException ex) 
        {
            System.out.println("Closing error");
        }
    }
    public static void main(String args[])
    {
       
        
    }
    
}

