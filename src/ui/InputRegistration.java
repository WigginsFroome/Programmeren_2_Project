
package ui;

import java.util.ArrayList;

import DatabaseConnection.Communication;
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
import person.Cursist;
import products.Cursus;

public class InputRegistration {

    private Communication com = new Communication();
    private ArrayList<String> courses = new ArrayList<>();
    private ArrayList<String> emails = new ArrayList<>();

    public Parent getView(){
        GridPane layout = new GridPane();
        String courseQuery = "SELECT CursusName FROM Cursus";
        this.courses = com.getListFromDatabase(courseQuery, "CursusName");
        String emailQuery = "SELECT Email FROM Cursist";
        this.emails = com.getListFromDatabase(emailQuery, "Email");

        Label nameInstruction = new Label("Cursus Naam");
        ComboBox nameField = new ComboBox(FXCollections .observableArrayList(this.courses));
        Label emailInstruction = new Label("Email");
        ComboBox emailField = new ComboBox(FXCollections .observableArrayList(this.emails));
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
            String name = (String) nameField.getValue();
            String email = (String) emailField.getValue();
            String date = dateField.getText();
            String[] parts = date.split("-");
            date = parts[2] + "-" + parts[1] + "-" + parts[0];
            String SQL = "INSERT INTO Registration VALUES('"+ date + "','" + email + "','" + name + "')";
            com.addToDatabase(SQL);
            dateField.clear();
        });

        return layout;
    }
}
