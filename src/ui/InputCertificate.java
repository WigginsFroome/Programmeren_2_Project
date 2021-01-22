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

public class InputCertificate {
    private ArrayList<Certificate> list;

    public InputCertificate(Certificate certificate){
        this.list = new ArrayList<>();
        this.list.add(certificate);
    }

    public Parent getView(){
        GridPane layout = new GridPane();

        Label nameInstruction = new Label("Cursus Naam");
        TextField nameField = new TextField();
        Label gradeInstruction = new Label("Cijfer");
        TextField gradeField = new TextField();
        Label emailInstruction = new Label("Email");
        TextField emailField = new TextField();
        Label employeeInstruction = new Label("Naam medewerker");
        TextField employeeField = new TextField();
        Label dateInstruction = new Label("Registratie datum");
        TextField dateField = new TextField();
        

        layout.setAlignment(Pos.CENTER);
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setPadding(new Insets(10, 10, 10, 10));

        Button addButton = new Button("Add certificate");

        layout.add(nameInstruction, 0, 0);
        layout.add(nameField, 0, 1);
        layout.add(gradeInstruction, 0, 2);
        layout.add(gradeField, 0, 3);
        layout.add(emailInstruction, 0, 4);
        layout.add(emailField, 0, 5);
        layout.add(employeeInstruction, 0, 6);
        layout.add(employeeField, 0, 7);
        layout.add(dateInstruction, 0, 8);
        layout.add(dateField, 0, 9);
        layout.add(addButton, 0, 10);
       

        addButton.setOnMouseClicked((event) -> {
            String name = nameField.getText();
            String grade = gradeField.getText();
            String email = emailField.getText();
            String employee = employeeField.getText();
            String date = dateField.getText();
            

            //list.add(name, subject, intro, difficulty);

            nameField.clear();
            gradeField.clear();
            emailField.clear();
            employeeField.clear();
            dateField.clear();
        });

        return layout;
    }
}
