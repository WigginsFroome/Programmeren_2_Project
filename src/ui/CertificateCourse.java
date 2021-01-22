package ui;
import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import person.Certificate;
import products.Cursus;

public class CertificateCourse{
    private ArrayList<Cursus> list1;
    private ArrayList<Certificate> list2;
    private ArrayList<String> list3;

    public CertificateCourse(Cursus cursus, Certificate certificate){
        this.list1 = new ArrayList<>();
        this.list1.add(cursus);
        this.list2 = new ArrayList<>();
        this.list2.add(certificate);
    }

    
    //Hierin wordt de methode aangemaakt om aan list3 de top3 cursussen toe te voegen met meest uitgedeelde certificaten
    public void getTop3(){
        int countCertificate = 0;
    }

    //In deze view hoeven enkel de 3 meest bekeken webcasts te komen
    public Parent getView(){
        GridPane layout = new GridPane();

        

        layout.setAlignment(Pos.CENTER);
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setPadding(new Insets(10, 10, 10, 10));



        

        return layout;
    }
}