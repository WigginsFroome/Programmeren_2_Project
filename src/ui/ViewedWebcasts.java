package ui;

import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import products.Webcast;
import person.Cursist;

public class ViewedWebcasts {
    private ArrayList<Cursist> list;
    private ArrayList<Webcast> list2;
    private ArrayList<String> list3;

    public ViewedWebcasts(Cursist cursist, Webcast webcast){
        this.list = new ArrayList<>();
        this.list.add(cursist);
        this.list2 = new ArrayList<>();
        this.list2.add(webcast);
    }
    
    //Hierin wordt de methode aangemaakt om aan list3 de meest bekeken webcasts toe te voegen 
    public void getTop3(){

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
