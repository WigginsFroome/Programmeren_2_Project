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
import products.Cursus;
import products.Module;
import ui.Main;

public class ModuleView {
    private Main com = new Main();
    private ArrayList<Cursus> cursus;
    private ArrayList<Module> module;
    private ArrayList<String> courses = new ArrayList<>();
    private ArrayList<String> modules = new ArrayList<>();
    
    public ModuleView(Cursus course, Module modules){
        this.module = new ArrayList<>();
        module.add(modules);
        this.cursus = new ArrayList<>();
        cursus.add(course);
    }

    public void getProgress(){

    }

    public Parent getView(){
        GridPane layout = new GridPane();

        

        Label courseLabel = new Label("Cursus");
        TextField courseTextField = new TextField();
        ComboBox courseField = new ComboBox(FXCollections.observableArrayList(this.courses));;
        

        layout.setAlignment(Pos.CENTER);
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setPadding(new Insets(10, 10, 10, 10));

        Button getButton = new Button("Get percentage");

        layout.add(courseLabel, 0, 0);
        layout.add(courseTextField, 0, 1);
        layout.add(getButton, 0, 2);

        getButton.setOnMouseClicked((event) -> {
            String cursus = courseTextField.getText();
            String cursus1 = (String) courseField.getValue();

            String SQL = 
            "(SELECT AVG(Percentage) AS 'Percentage', Module.OrderNumber FROM Cursist JOIN PercentageWatched ON PercentageWatched.Email = Cursist.Email JOIN Content ON Content.ContentItemId = PercentageWatched.ContentItemId JOIN Module ON Module.ContentItemId = Content.ContentItemId JOIN Cursus ON Cursus.CursusName = Content.CursusName GROUP BY OrderNumber)";
            String cursusQuery = "SELECT CursusName FROM Course";
            this.courses = com.getList1FromDatabase(cursusQuery, "CursusName");
            String moduleQuery = "SELECT OrderNumber FROM Module";
            this.modules = com.getList1FromDatabase(moduleQuery, "OrderNumber");

            System.out.println(SQL);  
            
        
            courseTextField.clear();
        });

        return layout;
    }
}
