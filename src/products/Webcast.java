
package products;

public class Webcast {
    private int id;
    private String duration;
    private String url;
    private String expertName;
    private String expertOrganisation;
    
    
    public Webcast(/*String duration, String url, String expertName, String expertOrganisation*/){
        this.duration = duration;
        this.url = url;
        this.expertName = expertName;
        this.expertOrganisation = expertOrganisation;
    }
    
    public void getId(Content content){
        this.id = content.setId();
    }
            
}
