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
import person.Cursist;
import products.Cursus;

public class InputRegistration {

    public InputRegistration(){
    }

    public Parent getView(){
        GridPane layout = new GridPane();

        Label nameInstruction = new Label("Cursus Naam");
        TextField nameField = new TextField();
        Label emailInstruction = new Label("Email");
        TextField emailField = new TextField();
        Label dateInstruction = new Label("Registratie datum");
        TextField dateField = new TextField();
        

        layout.setAlignment(Pos.CENTER);
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setPadding(new Insets(10, 10, 10, 10));

        Button addButton = new Button("Add registration");

        layout.add(nameInstruction, 0, 0);
        layout.add(nameField, 0, 1);
        layout.add(emailInstruction, 0, 2);
        layout.add(emailField, 0, 3);
        layout.add(dateInstruction, 0, 4);
        layout.add(dateField, 0, 5);
        layout.add(addButton, 0, 6);
       

        addButton.setOnMouseClicked((event) -> {
            String name = nameField.getText();
            String email = emailField.getText();
            String date = dateField.getText();
            

            //list.add(name, subject, intro, difficulty);

            nameField.clear();
            emailField.clear();
            dateField.clear();
        });

        return layout;
    }
}
