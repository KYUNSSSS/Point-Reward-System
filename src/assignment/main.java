package assignment;
import java.io.BufferedWriter;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Hp
 */

public class main {
       static int phonenum;
       static int choice;
       static int currentUser=0;
       static boolean result;
//       static double point;
       //System allow n number users to register(in this case 10)
       static Customer[]customer = new Customer[100];
       
    
    public static void main(String[] args) {
        
        Loyalty loyalty = new Loyalty();
       // Point pts = new Point(customer[currentUser]);
//        Redemption rdp = new Redemption();
       RedemptionProduct reProd = RedemptionProduct.iniReProd();
       LimitedProduct liProd = LimitedProduct.iniLiProd();
        Voucher voucher = Voucher.iniVoucher();
        Report report = new Report();

     
//         for (int x=0;x<customer.length;x++){
//             System.out.println(customer[x].getPhoneNum());
//         }
       Scanner input = new Scanner(System.in);
       Menu.splashScreen();
       pressEnterToContinue();
      do{
        readCustomersFile();
         
        Menu.mainMenu();
        choice = input.nextInt();
           switch (choice) {
               case 1:
                   customer[Customer.getUserRegistered()] = new Customer();
                   customer[Customer.getUserRegistered()].enterDetail();
                   System.out.println(Customer.getUserRegistered());
                   Menu.backAction();
                   break;
               case 2:                
                   do{
                    System.out.print("Enter Phone Number (0 to back): ");
                    phonenum = input.nextInt();   
                    if(phonenum ==0){
                       
                        break;
                        
                    }
                    for(int i= 0;i<customer.length;i++){
                     if(customer[i] != null){
                        if(customer[i].getPhoneNum()==phonenum){
                              System.out.println("User Found!");
                              result=true;
                              currentUser=i;
                              
                              do{
                    System.out.println("Welcome back,"+customer[currentUser].getName());
                    Menu.userMenu();
                    choice = input.nextInt();
                    switch(choice){
                        case 1:
                            customer[currentUser].updateDetail();
                           Menu.backAction();
                           
                            break;
                        case 2:
                            customer[currentUser].updateAmount();
                             Menu.backAction();
                            
                            break;
                        case 3:
                            Point pointInstance = new Point(customer);
                            pointInstance.checkAmount(customer);
                            pointInstance.checkExpiryDate(customer);
                            Menu.backAction();
                            
                            break;
                        case 4:
                            //Redemption.redemption(reProd, liProd, voucher);
//                            Scanner scanner = new Scanner(System.in);
//                            Menu.redeemMenu();
//                            int opt = scanner.nextInt();
//
//                            switch(opt){
//                                case 1:
//                                    rdp.redeemProduct(reProdNames,reQtyRemain,reRequiredPts);
//                                    break;
//                                case 2:
//                                    rdp.redeemProduct(liProdNames,liQtyRemain,liRequiredPts);
//                                    break;                
//                                case 3:
//                                    rdp.redeemProduct(vcNames,vcQtyRemain,vcRequiredPts);
//                                    break;
//                                default:
//                                    System.out.print("Cancelled redemption");
//                            }
                            break;
                        case 5:
                            double amount = customer[currentUser].getTotalPurchaseAmount();
                            loyalty.updateTier(customer);
                            System.out.println(customer[currentUser].displayProfile());
                            System.out.println(loyalty.displayTier());
                            System.out.println();
                            
                            break;
                        case 6:
                            customer[currentUser].updateReferralCode();
                            updateCustomerFile(customer);
                            Menu.backAction();
                            break;   
                        case 7:
                            Menu.backAction();
                            break;       
                        default:
                            Menu.backAction();                         
                    }
                    updateCustomerFile(customer);
                   }while(choice!=7 && result==true);
                              choice=0;
                              break;
                             }
                       }
                   }
                   if(result==false){
                                System.out.println("User not found,Please Try Again.");
                                }
                    
                   
                   }while(result==false);
                   
                   break;
               case 3:
                   System.out.println("Thank you for using our system!");
                        break;
               case 4:
                    String username = input.next();
                    String apw = input.next();
                    File adminfile = new File("adminfile.txt");
                    try {
                        Scanner a = new Scanner(adminfile);
                        while (a.hasNextLine()) {
                            String line = a.nextLine();
                            String[] values = line.split(",");
                            
                            String chkUsername = values[1];
                            String chkApw = values[2];    
                            
                            if (username.equals(chkUsername)){
                                if (apw.equals(chkApw)){
                                    Menu.reportMenu();
                                    int choice = input.nextInt();
                                    switch (choice) {
                                        case 1:
                                            loyalty.updateTier(customer);
                                            report.calculateTierCust(customer);
                                            System.out.println(report.displayReport());
                                            break;
                                        case 2:
                                            
                                            break;
                                        case 3:

                                            
                                    }
                                    
                                }
                            }
                        }
                    } catch (IOException e) {
                        System.out.println("An error occurred while reading customer data.");
                        e.printStackTrace();
                    }
               default:
                   break;
           }
           updateCustomerFile(customer);
      }while(choice !=3 );    
     
    }
    public static boolean chkPhoneNumber(int hpnum){
        File custfile = new File("customerfile.txt");
            try {
               
                //FileWriter writer = new FileWriter(custfile,true);
                Scanner read = new Scanner(custfile);
                while (read.hasNextLine()) {
                    String line = read.nextLine();
                    String[] values = line.split(",");
                    if (values.length > 0) {
                        if(hpnum == Integer.parseInt(values[4])){
                           result=true;
                            break; 
                        }else{
                            result=false;
                        }

                    }
                }
            } catch (IOException e) {
              System.out.println("An error occurred.");
            }
        return result;
   }
    public static void readCustomersFile() {
        currentUser = 0;
        for (int i = 0; i < customer.length; i++) {
            customer[i] = null;  
        }
        File custFile = new File("customerfile.txt");
        try {
            Scanner scanner = new Scanner(custFile);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] values = line.split(",");

                
                Customer newCustomer = new Customer();

                newCustomer.setName(values[1]); // Example, modify according to your class structure
                newCustomer.setAge(Integer.parseInt(values[2]));
                newCustomer.setEmail(values[3]);
                newCustomer.setPhoneNum(Integer.parseInt(values[4]));
                newCustomer.setTotalPurchaseAmount(Double.parseDouble(values[5]));
                String dateString = values[6]; // Assuming values[6] contains the date string
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate pointDate = LocalDate.parse(dateString, formatter);
                newCustomer.setPointDate(pointDate);
                
                // Add the new customer to the customer array
                customer[currentUser++] = newCustomer;

                // Break if the customer array is filled
                if (currentUser >= customer.length) {
                
                    break;
                }
            }
            scanner.close();
        } catch (IOException e) {
            System.out.println("An error occurred while reading customer data.");
            e.printStackTrace();
        }
    }

    public static void file(){
        File custfile = new File("customerfile.txt");
            try {
               
            FileWriter writer = new FileWriter(custfile,true);
            Scanner read = new Scanner(custfile);
            read.useDelimiter(",");

            } catch (IOException e) {
              System.out.println("An error occurred.");
              e.printStackTrace();
            }
        
    }
    public static void updateCustomerFile(Customer[]customer) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("customerfile.txt"));
            for (int i = 0; i < customer.length; i++) {
                if (customer[i] != null) {
                    String customerData = i+","+customer[i].getName()+ "," + customer[i].getAge() + ","+customer[i].getEmail()+","+customer[i].getPhoneNum()+","+customer[i].getTotalPurchaseAmount()+","+customer[i].getPointDate().toString();
                    writer.write(customerData);
                    writer.newLine();
                }
            }
            writer.close();
           // System.out.println("Customer file updated successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while updating customer file.");
            e.printStackTrace();
        }
    }

    public static void pressEnterToContinue()
 { 
         System.out.println("Press Enter key to continue...");
        try
        {
            System.in.read();
        }  
        catch(Exception e)
        {}  
 }

}
