package ui;

import java.util.ArrayList;

import DatabaseConnection.Communication;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import products.Cursus;


public class InputCourse {
    private ArrayList<Cursus> list;
    private Communication com = new Communication();

    public InputCourse(Cursus course) {
        this.list = new ArrayList<>();
        this.list.add(course);
    }

    public Parent getView() {
        GridPane layout = new GridPane();

        Label nameInstruction = new Label("Cursus Naam");
        TextField nameField = new TextField();
        Label subjectInstruction = new Label("Onderwerp");
        TextField subjectField = new TextField();
        Label introInstruction = new Label("Intro tekst");
        TextField introField = new TextField();
        Label difficultyInstruction = new Label("Moeilijkheidsgraad");
        TextField difficultyField = new TextField();

        layout.setAlignment(Pos.CENTER);
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setPadding(new Insets(10, 10, 10, 10));

        Button addButton = new Button("Add course");

        layout.add(nameInstruction, 0, 0);
        layout.add(nameField, 0, 1);
        layout.add(subjectInstruction, 0, 2);
        layout.add(subjectField, 0, 3);
        layout.add(introInstruction, 0, 4);
        layout.add(introField, 0, 5);
        layout.add(difficultyInstruction, 0, 6);
        layout.add(difficultyField, 0, 7);
        layout.add(addButton, 0, 8);

        addButton.setOnMouseClicked((event) -> {
            String name = nameField.getText();
            String subject = subjectField.getText();
            String intro = introField.getText();
            int difficulty = Integer.valueOf(difficultyField.getText());
            String SQL = "INSERT INTO Cursus VALUES('" + name + "','" + subject + "','" + intro + "','" + difficulty+ "')";
            com.addToDatabase(SQL);

            nameField.clear();
            subjectField.clear();
            introField.clear();
            difficultyField.clear();
        });

        return layout;
    }
}
