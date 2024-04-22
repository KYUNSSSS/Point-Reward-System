/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package assignment;

import java.util.Scanner;

/**
 *
 * @author Hp
 */
public class Customer {
    Scanner input = new Scanner(System.in);
    private String name = "";
    private int age = 0;
    private String email = "";
    private int phoneNum = 0 ;
    private double totalPurchaseAmount = 0;
    private static int userRegistered;
    
     public Customer() {
    }

    
    public Customer(String name, int age, String email, int phoneNum, double totalPurchaseAmount) {
    
        this.name = name;
        this.age = age;
        this.email = email;
        this.phoneNum = phoneNum;
        this.totalPurchaseAmount = totalPurchaseAmount;
        userRegistered++;
    }

   
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(int phoneNum) {
        this.phoneNum = phoneNum;
    }

    public double getTotalPurchaseAmount() {
        return totalPurchaseAmount;
    }

    public void setTotalPurchaseAmount(double totalPurchaseAmount) {
        this.totalPurchaseAmount = totalPurchaseAmount;
    }

    public static int getUserRegistered() {
        return userRegistered;
    }

    public static void setUserRegistered(int userRegistered) {
        Customer.userRegistered = userRegistered;
    }
    
    public void enterDetail(){
        System.out.print("Enter Name(Ali bin Abu): ");
        name = input.nextLine();
        
        System.out.print("Enter Age: ");
        age = input.nextInt();
       
        System.out.print("Enter Email(example@gmail.com): ");
        email = input.nextLine();
        input.next();
        
        System.out.print("Enter Phone Number(0123456789): ");
        phoneNum = input.nextInt();
        
        System.out.print("Enter Purchase Amount:RM ");
        totalPurchaseAmount = input.nextDouble();
        userRegistered++;
        System.out.println("Registered Successfully.");
    
    }
    public boolean checkDetail(int phoneNum){
    
        boolean bool;
      
        
        if (phoneNum == getPhoneNum()){
            System.out.println("User Found!");
            bool =true;
        }else{
            bool = false;
        }
           
            
        return bool;
       }
    public void updateDetail(){
        int num;
        int choice;
        
        
        
        
            System.out.println("\nWhat to update?\n1.Name\n2.Age\n3.Email\n4.Phone Number\n5.Back\nSelect One:");
            choice= input.nextInt();
            
            if(choice ==1){
      
                System.out.print("Enter Name: ");
                input.nextLine();
                name = input.nextLine();
                System.out.printf("%s %s" ,"Name changed: ",name+"\n");
            }else if(choice ==2){
                System.out.println("SYSTEM DEVELOPING.. :)");
            }else if(choice ==3){
                System.out.println("SYSTEM DEVELOPING.. :)");
            }else if(choice ==4){
                System.out.println("SYSTEM DEVELOPING.. :)");
            }
                  

       }
    public void updateAmount(){
        int num;
        
        
    }
    
 
 
   
    
}