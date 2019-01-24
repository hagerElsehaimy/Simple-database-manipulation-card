/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

/**
 *
 * @author nlamei
 */
public class Person {
    //static int ID_Generator;
    private String ID;
    private String First_Name, Middle_Name, Last_Name, Email, Phone;

    public Person() 
    {
        
    }
    
    public Person(String fn, String mn, String ln, String email, String phone)
    {
        
        this.First_Name = fn;   
        this.Last_Name = ln;  
        this.Middle_Name = mn; 
        this.Email = email;   
        this.Phone = phone;
    }
    
    public void setId(String id ) 
    {
        this.ID = id;
    }
    public void setFirstName(String fn ) 
    {
        this.First_Name= fn;
    }
    public void setMiddleName(String mn ) 
    {
        this.Middle_Name=mn;
    }
    public void setLastName(String ln ) 
    {
        this.Last_Name=ln;
    }
    public void setEmail(String email ) 
    {
        this.Email=email;
    }
    public void setPhone(String phone ) 
    {
        this.Phone=phone;
    }
    
    public String getId( ) 
    {
        return this.ID;
    }
    public String getFirstName() 
    {
        return this.First_Name;
    }
    public String getMiddleName() 
    {
        return this.Middle_Name;
    }
    public String getLastName() 
    {
        return this.Last_Name;
    }
    public String getEmail() 
    {
        return this.Email;
    }
    public String getPhone() 
    {
        return this.Phone;
    }

}