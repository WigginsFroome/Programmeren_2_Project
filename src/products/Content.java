
package products;

import java.util.Date;

public class Content {
    private int id;
    private Date publicationDate;
    private String status;
    private String title;
    private String description;
    private String cursusName;
    private int moduleId;
    private int webcastId;
    
    public Content(int id, Date publicationDate,String status, String title, String description, Cursus cursus){
        this.id = id;
        this.publicationDate = publicationDate;
        this.status = status;
        this.title = title;
        this.description = description;
        this.cursusName = cursus.getCursusName();
    }
    
    public int setId(){
        return this.id;
    }
}
