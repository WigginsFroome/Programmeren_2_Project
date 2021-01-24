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
import person.Cursist;
import ui.Main;




public class GenderView {
    int total = 0;
    int pass = 0;
    private Main com = new Main();
    private ArrayList<String> genders = new ArrayList();

    public GenderView(Cursist cursist){

    }

    public void getPercentage(Cursist cursist, Certificate certificate){

    }

    public Parent getView(){
        GridPane layout = new GridPane();

        String genderQuery = "SELECT Gender FROM Cursist";
        this.genders = com.getList1FromDatabase(genderQuery, "Gender");

        Label genderLabel = new Label("Gender (M / F)");
        TextField genderTextField = new TextField();
        ComboBox genderField = new ComboBox(FXCollections.observableArrayList(this.genders));

        layout.setAlignment(Pos.CENTER);
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setPadding(new Insets(10, 10, 10, 10));

        Button getButton = new Button("Get percentage");

        layout.add(genderLabel, 0, 0);
        layout.add(genderTextField, 0, 1);
        layout.add(getButton, 0, 2);

        getButton.setOnMouseClicked((event) -> {
            String gender = genderTextField.getText();
            String gender1 = (String) genderField.getValue();

            String SQL = 
            "(SELECT Name, Cursist.Email, CertificateId FROM Cursist JOIN Registration ON Registration.Email = Cursist.Email JOIN Cursus ON Cursus.CursusName = Registration.CursusName LEFT JOIN Certificate ON Certificate.RegistrationDate = Registration.RegistrationDate WHERE gender = this.gender)";
            System.out.println(SQL);  
            com.addToDatabase(SQL);
            for(int i = 0; i < gender.length(); i++){
                for(int j = 0; j < gender1.length(); j++){
                    int percentage;
                    percentage = (j / i) * 100;
                    System.out.println(percentage);
                }
            }
        
            genderTextField.clear();
        });

        return layout;



    }
}