package ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import products.Module;

public class ModuleView {
    
    public ModuleView(Module module){

    }

    public void getProgress(){

    }

    public Parent getView(){
        GridPane layout = new GridPane();

        Label courseLabel = new Label("Type the course");
        TextField courseTextField = new TextField();
        

        layout.setAlignment(Pos.CENTER);
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setPadding(new Insets(10, 10, 10, 10));

        Button getButton = new Button("Get percentage");

        layout.add(courseLabel, 0, 0);
        layout.add(courseTextField, 0, 1);
        layout.add(getButton, 0, 2);

        getButton.setOnMouseClicked((event) -> {

        });

        return layout;
    }
}
