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

public class PassedCourse {
    private Communication com = new Communication();
    private ArrayList<String> courses = new ArrayList<>();
    private ArrayList<String> passedCourses = new ArrayList<>();

    public Parent getView(){
        GridPane layout = new GridPane();

        String courseQuery = "SELECT CursusName FROM Registration GROUP BY CursusName";
        this.courses = com.getListFromDatabase(courseQuery, "CursusName");

        Label courseLabel = new Label("Select course");
        ComboBox nameField = new ComboBox(FXCollections .observableArrayList(this.courses));
        Label answerLabel = new Label();

        layout.setAlignment(Pos.CENTER);
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setPadding(new Insets(10, 10, 10, 10));

        Button getButton = new Button("Get amount");

        layout.add(courseLabel, 0, 0);
        layout.add(nameField, 0, 1);
        layout.add(getButton, 0, 2);
        layout.add(answerLabel, 0,3);
        getButton.setOnMouseClicked((event) -> {
            String cursus = (String) nameField.getValue();
            String SQL = "SELECT CertificateId FROM Certificate WHERE CursusName = '"+ cursus +"'";
            System.out.println(SQL);
            this.passedCourses = com.getListFromDatabase(SQL, "CertificateId");
            int answer = this.passedCourses.size();
            String answerText = String.valueOf(answer);
            answerLabel.setText(answerText + " Cursisten hebben hem behaald");
        });

        return layout;
    }
}
