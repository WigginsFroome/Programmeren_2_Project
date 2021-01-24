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




public class GenderView {
    int total = 0;
    int pass = 0;
    private Communication com = new Communication();
    private ArrayList<String> genders = new ArrayList();
    private ArrayList<String> allCertificates = new ArrayList();

    public GenderView(Cursist cursist){

    }

    public Parent getView(){
        GridPane layout = new GridPane();

        String genderQuery = "SELECT Gender FROM Cursist GROUP BY Gender";
        this.genders = com.getListFromDatabase(genderQuery, "Gender");

        Label genderLabel = new Label("Gender (M / V)");
        ComboBox genderField = new ComboBox(FXCollections.observableArrayList(this.genders));
        Label answerField = new Label();
        layout.setAlignment(Pos.CENTER);
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setPadding(new Insets(10, 10, 10, 10));

        Button getButton = new Button("Percentage");

        layout.add(genderLabel, 0, 0);
        layout.add(genderField, 0, 1);
        layout.add(getButton, 0, 2);
        layout.add(answerField, 0, 3);

        getButton.setOnMouseClicked((event) -> {
            String gender = (String) genderField.getValue();
            String allCertificatesQuery = "(SELECT Registration.Email FROM Cursist JOIN Registration ON Registration.Email = Cursist.Email JOIN Cursus ON Cursus.CursusName = Registration.CursusName WHERE gender = '" + gender +"')";
            String SQL = "(SELECT CertificateId FROM Cursist JOIN Registration ON Registration.Email = Cursist.Email JOIN Cursus ON Cursus.CursusName = Registration.CursusName JOIN Certificate ON Certificate.RegistrationDate = Registration.RegistrationDate WHERE gender = '" + gender + "')";
            this.genders = com.getListFromDatabase(SQL, "CertificateId");
            this.allCertificates = com.getListFromDatabase(allCertificatesQuery , "Email");
            double certificates = this.genders.size();
            double everyone = this.allCertificates.size();
            double answer = (certificates / everyone) * 100;
            System.out.println(certificates);
            System.out.println(everyone);
            System.out.println(answer);
            String answerText = String.valueOf(answer);
            answerField.setText(answerText);
            });

        return layout;

    }
}
