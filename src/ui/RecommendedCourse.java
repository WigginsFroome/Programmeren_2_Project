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

public class RecommendedCourse {
    private ArrayList<Cursus> listCourse;
    private ArrayList<String> listRecommended;
    
    public RecommendedCourse(){
        this.listCourse = new ArrayList<>();
        this.listRecommended = new ArrayList<>();    
    }

    public void getRecommended(){

    }

    public Parent getView(){
        GridPane layout = new GridPane();

        Label courseLabel = new Label("Select a course");
        TextField courseTextField = new TextField();
        

        layout.setAlignment(Pos.CENTER);
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setPadding(new Insets(10, 10, 10, 10));

        Button getButton = new Button("Go");

        
        layout.add(courseLabel, 0, 1);
        layout.add(courseTextField, 0, 2);
        layout.add(getButton, 0, 3);

        getButton.setOnMouseClicked((event) -> {

        });

        

        return layout;
    }
}
