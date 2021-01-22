package ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import person.Certificate;
import person.Cursist;

public class GenderView {
    int total = 0;
    int pass = 0;

    public GenderView(Cursist cursist){

    }

    public void getPercentage(Cursist cursist, Certificate certificate){

    }

    public Parent getView(){
        GridPane layout = new GridPane();

        Label genderLabel = new Label("Type the gender (M / F)");
        TextField genderTextField = new TextField();

        layout.setAlignment(Pos.CENTER);
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setPadding(new Insets(10, 10, 10, 10));

        Button getButton = new Button("Get percentage");

        layout.add(genderLabel, 0, 0);
        layout.add(genderTextField, 0, 1);
        layout.add(getButton, 0, 2);

        getButton.setOnMouseClicked((event) -> {

        });

        return layout;



    }
}