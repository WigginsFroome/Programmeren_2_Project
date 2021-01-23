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

public class InputCertificate {
    private ArrayList<Certificate> list;
    private Communication com = new Communication();
    private ArrayList<String> courses = new ArrayList<>();
    private ArrayList<String> dates = new ArrayList<>();
    private ArrayList<String> emails = new ArrayList<>();
    public InputCertificate(Certificate certificate) {
        this.list = new ArrayList<>();
        this.list.add(certificate);
    }

    public Parent getView() {
        GridPane layout = new GridPane();

        String courseQuery = "SELECT CursusName FROM Registration";
        this.courses = com.getListFromDatabase(courseQuery, "CursusName");
        String dateQuery = "SELECT RegistrationDate FROM Registration";
        this.dates = com.getListFromDatabase(dateQuery, "RegistrationDate");
        String emailQuery = "SELECT Email FROM Registration";
        this.emails = com.getListFromDatabase(emailQuery, "Email");
        Label nameInstruction = new Label("Cursus Naam");
        ComboBox nameField = new ComboBox(FXCollections .observableArrayList(this.courses));
        Label gradeInstruction = new Label("Cijfer");
        TextField gradeField = new TextField();
        Label emailInstruction = new Label("Email");
        ComboBox emailField = new ComboBox(FXCollections .observableArrayList(this.emails));
        Label employeeInstruction = new Label("Naam medewerker");
        TextField employeeField = new TextField();
        Label dateInstruction = new Label("Registratie datum");
        ComboBox dateField = new ComboBox(FXCollections .observableArrayList(this.dates));

        System.out.println(this.dates);
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
            String name = (String) nameField.getValue();
            String grade = gradeField.getText();
            String email = (String) emailField.getValue();
            String employee = employeeField.getText();
            String date = (String) dateField.getValue();
            String SQL = "INSERT INTO Certificate(Grade, EmployeeName, RegistrationDate, Email, CursusName) VALUES('"+ grade + "','" + employee + "','" + date + "','" + email + "','" + name + "')";
            System.out.println(SQL);
            com.addToDatabase(SQL);

            gradeField.clear();
            employeeField.clear();
        });

        return layout;
    }
}
