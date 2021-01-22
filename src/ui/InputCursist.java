package ui;

import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import person.Cursist;

public class InputCursist {
    private ArrayList<Cursist> list;

    public InputCursist(Cursist cursist){
        this.list = new ArrayList<>();
        this.list.add(cursist);
    }

    public Parent getView(){
        GridPane layout = new GridPane();

        Label emailInstruction = new Label("Email");
        TextField wordField = new TextField();
        Label nameInstruction = new Label("Naam");
        TextField nameField = new TextField();
        Label geboorteInstruction = new Label("GeboorteDatum");
        TextField geboorteField = new TextField();
        Label geslachtInstruction = new Label("Geslacht");
        TextField geslachtField = new TextField();
        Label adresInstruction = new Label("Adres");
        TextField adresField = new TextField();
        Label woonplaatsInstruction = new Label("Woonplaats");
        TextField woonplaatsField = new TextField();
        Label landInstruction = new Label("Land");
        TextField landField = new TextField();

        layout.setAlignment(Pos.CENTER);
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setPadding(new Insets(10, 10, 10, 10));

        Button addButton = new Button("Add cursist");

        layout.add(emailInstruction, 0, 0);
        layout.add(wordField, 0, 1);
        layout.add(nameInstruction, 0, 2);
        layout.add(nameField, 0, 3);
        layout.add(geboorteInstruction, 0, 4);
        layout.add(geboorteField, 0, 5);
        layout.add(geslachtInstruction, 0, 6);
        layout.add(geslachtField, 0, 7);
        layout.add(adresInstruction, 0, 8);
        layout.add(adresField, 0, 9);
        layout.add(woonplaatsInstruction, 0, 10);
        layout.add(woonplaatsField, 0, 11);
        layout.add(landInstruction, 0, 12);
        layout.add(landField, 0, 13);
        layout.add(addButton, 0, 14);

        addButton.setOnMouseClicked((event) -> {
            String word = wordField.getText();
            String naam = nameField.getText();
            String geboorte = geboorteField.getText();
            String geslacht = geslachtField.getText();
            String adres = adresField.getText();
            String woonplaats = woonplaatsField.getText();
            String land = landField.getText();

            //dictionary.add(word, naam, geboorte, geslacht, adres, woonplaats, land);

            wordField.clear();
            nameField.clear();
            geboorteField.clear();
            geslachtField.clear();
            adresField.clear();
            woonplaatsField.clear();
            landField.clear();
        });

        return layout;
    }
}
