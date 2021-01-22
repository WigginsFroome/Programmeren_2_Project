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

public class AccountCertificate {
    private ArrayList<Cursist> list;
    private ArrayList<Certificate> list2;

    public AccountCertificate(Cursist cursist, Certificate certificate){
        this.list = new ArrayList<>();
        this.list.add(cursist);
        this.list2 = new ArrayList<>();
        this.list2.add(certificate);
    }

    public Parent getView(){
        GridPane layout = new GridPane();

        Label cursistLabel = new Label("Type the cursist");
        TextField cursistTextField = new TextField();
        

        layout.setAlignment(Pos.CENTER);
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setPadding(new Insets(10, 10, 10, 10));

        Button getButton = new Button("Get progress");

        layout.add(cursistLabel, 0, 0);
        layout.add(cursistTextField, 0, 1);
        layout.add(getButton, 0, 2);

        getButton.setOnMouseClicked((event) -> {

        });

        return layout;
    }
}
