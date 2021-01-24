package ui;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import person.Certificate;
import products.Cursus;

public class CertificateCourse{
    private ArrayList<String> courses = new ArrayList<>();
    private ArrayList<Cursus> cursus;

    public CertificateCourse(Cursus course){
        this.cursus = new ArrayList<>();
        this.cursus.add(course);
    }

    
    

    //In deze view komen de hoeveelheid behaalde cursussen
    public Parent getView(){
        GridPane layout = new GridPane();

        Label courseLabel = new Label("Cursus");
        TextField courseTextField = new TextField();
        ComboBox courseField = new ComboBox(FXCollections.observableArrayList(this.courses));

        layout.setAlignment(Pos.CENTER);
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setPadding(new Insets(10, 10, 10, 10));

        Button button = new Button("Get cursists");
        layout.add(courseLabel, 0, 0);
        layout.add(courseTextField, 0, 1);
        layout.add(button, 0, 2);

        button.setOnMouseClicked((event) -> {
            String SQL = 
            "(SELECT Cursus.CursusName, COUNT(Name) AS Behaald FROM Cursus JOIN Registration ON Registration.CursusName = Cursus.CursusName JOIN Cursist ON Cursist.Email = Registration.Email JOIN Certificate ON Certificate.RegistrationDate = Registration.RegistrationDate GROUP BY Cursus.CursusName)";
            

            System.out.println(SQL);  
            
        
            
        });


        

        return layout;
    }
}