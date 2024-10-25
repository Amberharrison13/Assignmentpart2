/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignmentpart2;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;    
/**
 *
 * @author RC_Student_lab
 */
public class LoginClass {
    private boolean Found=false;
    private boolean check=false;
    // User data storage
    private final Map<String, User> users = new HashMap<>();
    private boolean loginstatus=false;

    // Nested class to represent a User
    private static class User {
        String password;
        String firstName;
        String lastName;

        User(String password, String firstName, String lastName) {
            this.password = password;
            this.firstName = firstName;
            this.lastName = lastName;
        }
    }

    // Method to check if the username meets the format requirements
    public boolean CheckUsername(String username){  
        //temp varaiable for checking
        boolean Found=false;
        
        //check the username
        if(username.contains("_") && username.length()<=5){
            //the assign to true
            check= true;
            //message
            System.out.println("username is captured");
            
        }else{
            //assign to false
            check= false;
            //message
            System.out.println("username is not captured");
        }
        return check;
    }

    // Method to check if the password meets complexity requirements
    public boolean checkPassword(String password){
            //pattern regtex
            Pattern check_num = Pattern.compile( "[0123456789]");
            Pattern check_special = Pattern.compile("[*-`~!@#$%&_'^]");
            Pattern check_Upper =Pattern.compile("[QWERTYUIOPASDFGHJKLZXCVBNM]");
            
            //Temp variable found
            
            
            //check all here
            if(check_num.matcher(password).find()&& check_special.matcher("password").find()&&check_Upper.matcher(password).find()){
            Found= true;
            System.out.println("Password captured");
      
        }else{
           //assign to false
        Found=false;
        System.out.println("Password not captured");
                }
        return Found;
    }

    // Method to register a new user
    public String registerUser(String username, String password, String name, String lastname) {
        
        if(!check&&Found){
            System.out.println("username is not successfully captured");  
        }else if(check&&!Found){
            System.out.println("password is not successfully captured");   
        }else{
            System.out.println("Your registration is succesful");
        }
        
        
        return "  ";
    }

    // Method to verify login credentials
    public String loginUser(String username, String password) {
        User user = users.get(username);
        if (user != null && user.password.equals(password)) {
            return String.format("Welcome %s, %s. It is great to see you again.", user.firstName, user.lastName);
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
   public boolean returnloginstatus(){
       return loginstatus;
   } 
    
 
}