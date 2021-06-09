/**
 *ReadSer.java
 * This is the ReadSer.java class
 * @author Marvin Hope - 219445842
 * Due Date - 9 June 2021
 */

package za.ac.cput;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import static java.time.LocalDate.parse;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;

public class ReadSer {

    private ObjectInputStream input;
    private BufferedWriter BW;
    
    Customer customer;
    Supplier supplier;
    Object object;
    /*
    ========================================
    Arraylist of CUstomer and Supplier
    ========================================
    */
    private ArrayList<Customer> CusArray = new ArrayList<Customer>();
    private ArrayList<Supplier> SupArray = new ArrayList<Supplier>();
    
    /*
    ========================================
    Opens the file of Customer and reads fromm it
    ========================================
    */
    public void openFileC() {
        try{
             input = new ObjectInputStream(new FileInputStream("stakeholder.ser"));
             System.out.println("***serialized file is opened for reading ***");
         } 
         catch(IOException e) {
             System.out.println("Error!! Could not open file!" + e.getMessage());
         }           
    }
    /*
    ======================================
    Closes the Customer file
    ======================================
    */
    
    public void closeFileC() {
        try{
            input.close();
        }
        catch(IOException e) {
            System.out.println("Error!! Could not close file!" + e.getMessage());
        }
    }
/*
    =====================================
    Reads the file of Customer
    ====================================
    */
   
    public void readFileC() {
        try { 
            for (int i = 0; i <11; i++) {
                object= input.readObject();

                   if(object.getClass() == Customer.class){
                    customer = (Customer) object;
                    CusArray.add(customer);

                }
            }            
        }
        

        catch (IOException | ClassNotFoundException e) {
            System.out.println("Error!! Could not read file!" + e.getMessage());
            System.out.println("Class error reading ser file: " + e);
        }
        finally {
            closeFileC();
            System.out.println("*** file has been closed ***");
        }
    }
    /*
    ========================================
    Opens the file of Supplier and reads from it
    ========================================
    */
    
     public void openFileS() {
        try{
             input = new ObjectInputStream(new FileInputStream("stakeholder.ser"));
             System.out.println("***serialized file is opened for reading ***");
         } 
         catch(IOException e) {
             System.out.println("Error!! Could not open file!" + e.getMessage());
         }           
    }
      public void closeFileS() {
        try{
            input.close();
        }
        catch(IOException e) {
            System.out.println("Error!! Could not close file!" + e.getMessage());
        }
    }
/*
    =====================================
    Reads the file of Supplier
    ====================================
    */
    public void readFileS() {
        try{ 
            
            for (int i = 0; i <11; i++) {
                object = input.readObject();
                
                if(object.getClass() == Supplier.class){
                    
                    supplier = (Supplier) object;
                    SupArray.add(supplier);
                    
                }     
        }
        }
          catch (IOException | ClassNotFoundException e) {
            System.out.println("Error!! Could not read file!" + e.getMessage());
            System.out.println("Class error reading ser file: " + e);
        }
        finally {
            closeFileS();
            System.out.println("*** file has been closed ***");
        }
    }
    
    /*
    ==================================
    Sorting in ascending by the StakeholderId 
    ==================================
    */

      public void SortCus() {
             Collections.sort(CusArray,(stakeholderId1,stakholderId2)->{
              return stakeholderId1.getStHolderId().compareTo(stakholderId2.getStHolderId());
                   
          });
      }
      /*
      ================================
      Sorting the names in alphabetical order
      ===============================
      */
          public void SortSup(){
          Collections.sort(SupArray,(Sup0,Sup1)->{
              return Sup0.getName().compareTo(Sup1.getName());
                   
          });
      }    
    /*
    ==================================================
   c)	Determing the age of each customer 
    ==================================================
    */
    
    public int Age(String birthd) {
        LocalDate datebd0 = LocalDate.now();
        LocalDate datebd1 = LocalDate.parse(birthd,DateTimeFormatter.ISO_LOCAL_DATE);
        return Period.between(datebd1,datebd0).getYears();
    }
    
    /*
    ==============================================
    Opening a text file for Customer
    =============================================
    */
    
    public void openCusFile() {
        try{
              BW = new BufferedWriter (new FileWriter("customerOutFile.txt"));
        }
      catch (IOException e ){
          System.out.println("Error of opening the file" + e );
      }
    }
    
        public void closeCusFile(){
            try{
                BW.close();
            }
            catch(IOException e){
                System.out.println("Error from closing the file: ");
        }    
    }
        
        public String formatDatebob(Customer dob){
        LocalDate dateofBir = LocalDate.parse(dob.getDateOfBirth());
        DateTimeFormatter changeFormat = DateTimeFormatter.ofPattern("dd MMM yyyy");
        return dateofBir.format(changeFormat); 
        
    }
        
        /*
        =======================================================
        Headings of the text file and the functionality of rent
        =======================================================
        */
        public void writeCusFile(){
            try{
                int money = 0;

                BW.write("================== CUSTOMERS =======================\n");
                BW.write(String.format("%-17s%-17s%-17s%-17s%-17s\n","ID","Name", "Surname", "Date of Birth","Age"));
                BW.write("====================================================\n");
                
                for (int i = 0; i < CusArray.size(); i++) {
                      
    
                    BW.write(String.format("%-15s%-15s%-15s%-15s%-15d\n", CusArray.get(i).getStHolderId(),CusArray.get(i).getFirstName(),CusArray.get(i).getSurName(), formatDatebob(CusArray.get(i)),Age(CusArray.get(i).getDateOfBirth())));
                    if (CusArray.get(i).getCanRent() == true){
                    money++;

                }
                }
                        
          BW.write("\nNumber of customers that can rent: " + money);
          BW.write("\nNumber of customers that cannot rent: " + (CusArray.size() - money));         
        }

            catch (IOException e){
                System.out.println("Error closing the text file: " + e.getMessage());
            }  
           }       
        /*     
    ==============================================
    Opening a text file for Supplier
    =============================================
    */        

         public void openSupFile() {
        try{
              BW = new BufferedWriter (new FileWriter("supplierOutFile.txt"));
        }
      catch (IOException e ){
          System.out.println("Error of opening the file: " + e );
      }  
         }
           public void closeSupFile(){
            try{
                BW.close();
            }
            catch(IOException e){
                System.out.println("Error from closing the file: ");
        }    
    }
           /*
        =======================================================
        Headings of the text file of Supplier
        =======================================================
           */
        public void writeSupFile(){
            try{

                BW.write("================== SUPPLIERS =======================\n");
                BW.write(String.format("%-17s%-22s%-22s%-17s\n","ID","Name", "Product Type", "Description\n"));
                BW.write("====================================================\n");
                
                for (int j = 0; j < SupArray.size(); j++) {
                     BW.write(String.format("%-17s%-22s%-22s%-17s\n", SupArray.get(j).getStHolderId(),SupArray.get(j).getName(),SupArray.get(j).getProductType(),SupArray.get(j).getProductDescription()));
                }    
        }
            
            catch (IOException e){
                System.out.println("Error closing the text file: " + e.getMessage());
            }  
           }
    }
       