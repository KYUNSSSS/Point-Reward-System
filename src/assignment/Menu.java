/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;
//hi
import static assignment.main.customer;
import java.time.LocalDate;
//hehe
//hihi
/**
 *
 * @author Hp
 */
public class Menu {
    public static void splashScreen(){
        System.out.println("  ____  ______ ________          __     _____  _____  \n" +
" |  _ \\|  ____|  ____\\ \\        / /\\   |  __ \\|  __ \\ \n" +
" | |_) | |__  | |__   \\ \\  /\\  / /  \\  | |__) | |  | |\n" +
" |  _ <|  __| |  __|   \\ \\/  \\/ / /\\ \\ |  _  /| |  | |\n" +
" | |_) | |____| |____   \\  /\\  / ____ \\| | \\ \\| |__| |\n" +
" |____/|______|______|   \\/  \\/_/    \\_\\_|  \\_\\_____/ \n" +
"                                                      \n" +
"                                                      ");
        
    }
    public static void mainMenu(){
        System.out.print("1.Register New Account\n2.LOGIN TO EXISTING ACCOUNT\n3.Exit\nEnter Your Choice: ");
    }
    public static void userMenu(){
        System.out.print("1.Update Details\n2.Add New Transaction Amount\n3.Check Point Expiry\n4.Redeem Product\n5.Profile\n6.Referral Code\n7.Back\nEnter choice: ");
    }
    public static void backAction(){
        System.out.println("\n===========GOING BACK==========\n");
    }
    public static void addHardcodeCust(){
         customer[0] = new Customer("TAN AH KOW",21,"ahkow@gmail.com",122,150.00,LocalDate.of(2024,1,5));
    }
    
    public static void redeemMenu(){
        System.out.print("Redeem Option\n1. Product\n2. Limited Tier Product\n3. Voucher\n4. Exit\nChoose Redeem Option : ");
    }
    
    public static void reportMenu(){
        System.out.print("Type of Report\n1. Customer Tier Report\n2. Redemption Report\n3. Points Report\n4. Exit\nChoose Report Option : ");
    }

    public static void adminOrCustMenu(){
        System.out.print("Continue as\n1. Customer\n2. Admin User\n3. Exit\nEnter Selection:  ");
    }

}
