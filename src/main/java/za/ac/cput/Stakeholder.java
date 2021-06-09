/**
 *Stakeholder.java
 * This is the Stakeholder class
 * @author Marvin Hope - 219445842
 * Due Date 9 June 2021
 */
package za.ac.cput;

import java.io.Serializable;

public class Stakeholder implements Serializable {
    private String stHolderId;

    public Stakeholder() {
    }
    
    public Stakeholder(String stHolderId) {
        this.stHolderId = stHolderId;
    }
    
    public String getStHolderId() {
        return stHolderId;
    }

    public void setStHolderId(String stHolderId) {
        this.stHolderId = stHolderId;
    }

    @Override
    public String toString() {
       return stHolderId;
    }

}
