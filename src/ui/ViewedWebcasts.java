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
    private ArrayList<Webcast> list;
    private ArrayList<String> list1;

    public ViewedWebcasts(Webcast webcast){
        this.list = new ArrayList<>();
        this.list.add(webcast);
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
        Button button = new Button("Get Top3");
        layout.add(button, 0, 0);

        button.setOnMouseClicked((event) -> {
            

            String SQL = 
            "(SELECT WebcastId, COUNT(Webcast.ContentItemId) AS Bekeken FROM Content JOIN PercentageWatched ON PercentageWatched.ContentItemId = Content.ContentItemId JOIN Webcast ON Webcast.ContentItemId = Content.WebcastId GROUP BY WebcastId)";
            

            System.out.println(SQL);  
            
        
            
        });



        

        return layout;
    }
}
