
package products;

public class Module {
    private Content title;
    private Content id;
    private Content description;
    private String contactPersonName;
    private String contactPersonEmail;
    private int orderNumber;
    private double version;
    
    
    public Module(/*double version, int orderNumber, String contactPersonName, String contactPersonEmail*/){
        this.version = version;
        this.orderNumber = orderNumber;
        this.contactPersonName = contactPersonName;
        this.contactPersonEmail = contactPersonEmail;
    }
}
