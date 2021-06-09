/**
 *RunFile.java
 * this is the RunFile.java class
 * @author Marvin Hope - 299445842
 * Due Date 9 June 2021
 */
package za.ac.cput;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class RunFile {
    public static void main(String[] args) {
        ReadSer run = new ReadSer();
    /*
    =========================
    Read Customer and sort Customer
    =========================
        */
    run.openFileC();
    run.readFileC();
    run.SortCus();
    /*
    ============================
    Read Supplier and sort Supplier
    ============================
    */
    
    run.openFileS();
    run.readFileS();
    run.SortSup();
    
    /*
    ============================
    Supplier text document
    ============================
    */
    run.openSupFile();
    run.writeSupFile();
    run.closeSupFile();
    
    /*
    ============================
    Customer text document
    ============================
    */
    
    run.openCusFile();
    run.writeCusFile();
    run.closeCusFile();
    
    /*
    ===========================
    Reformat of the Date of birth
    ===========================
    */ 
        
    }
    
}
