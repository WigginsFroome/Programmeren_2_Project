
package ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import person.Cursist;
import products.Cursus;
import products.Module;
import javafx.scene.layout.BorderPane;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import person.Certificate;
import products.Webcast;

public class UI extends Application {
    private Cursist cursist;
    private Module module;
    private Certificate certificate;
    private Webcast webcast;
    private Cursus cursus;

    @Override
    public void init() throws Exception {
        // 1. Create the dictionary that the application uses
        this.cursist = new Cursist();
        this.module = new Module();
        this.certificate = new Certificate();
        this.webcast = new Webcast();
        this.cursus = new Cursus();

    }
    @Override
    public void start(Stage windows) {

        // 1. Creating the view for the GUI
        // 1.1 Creating an input view for a new variable
        InputCursist inputView = new InputCursist(cursist);
        InputCourse inputCourseView = new InputCourse(cursus);
        InputCertificate inputCertificate = new InputCertificate(certificate);
        InputRegistration inputRegistration = new InputRegistration();
        GenderView genderPercentage = new GenderView(cursist);
        ModuleView moduleView = new ModuleView(cursus, module);
        AccountCourseView accountCourseView = new AccountCourseView(cursist, module);
        AccountCertificate accountCertificateView = new AccountCertificate(cursist, certificate);
        ViewedWebcasts webcastView = new ViewedWebcasts(cursist, webcast);
        CertificateCourse courseView = new CertificateCourse(cursus, certificate);
        RecommendedCourse recommendedView = new RecommendedCourse();
        PassedCourse passedView = new PassedCourse();
        

        // 1.2 creating layout in the form of a BorderPane
        BorderPane layout = new BorderPane();

        // 3.1. Create the menu for the general layout
        HBox menu = new HBox();
        menu.setPadding(new Insets(20, 20, 20, 20));
        menu.setSpacing(10);

        // 3.2. Create the menu buttons
        Button addButton = new Button("Cursist add");
        Button addCourseButton = new Button("Cursus add");
        Button addCertificateButton = new Button("Certificate add");
        Button addRegistrationButton = new Button("Registration add");
        Button viewGenderButton = new Button("Certificates per gender");
        Button viewModuleProgressButton = new Button("Average progress per module");
        Button viewAccountCourseButton = new Button("Percentage progress per cursist and course");
        Button viewCourseButton = new Button("Certificates per account");
        Button viewWebcastsButton = new Button("Top 3 webcasts");
        Button viewCursusButton = new Button("Top 3 cursussen");
        Button viewRecommendedButton = new Button("Aanbevolen cursussen");
        Button viewPassedButton = new Button("Behaalde cursussen");

        // 1.4 creating a scene with the BorderPane (layout) inside of it
        Scene view = new Scene(layout);

        // 3.3. Add the buttons to the menu and add them at the top
        menu.getChildren().addAll(addButton, addCourseButton, addCertificateButton, addRegistrationButton, viewGenderButton, viewModuleProgressButton,viewAccountCourseButton, viewCourseButton, 
        viewWebcastsButton, viewCursusButton, viewRecommendedButton, viewPassedButton);
        layout.setTop(menu);

        // Connect the subviews with the buttons
        addButton.setOnAction((event) -> layout.setCenter(inputView.getView()));
        addCourseButton.setOnAction((event) -> layout.setCenter(inputCourseView.getView()));
        addCertificateButton.setOnAction((event) -> layout.setCenter(inputCertificate.getView()));
        addRegistrationButton.setOnAction((event) -> layout.setCenter(inputRegistration.getView()));
        viewGenderButton.setOnAction((event) -> layout.setCenter(genderPercentage.getView()));
        viewModuleProgressButton.setOnAction((event) -> layout.setCenter(moduleView.getView()));
        viewAccountCourseButton.setOnAction((event) -> layout.setCenter(accountCourseView.getView()));
        viewCourseButton.setOnAction((event) -> layout.setCenter(accountCertificateView.getView()));
        viewWebcastsButton.setOnAction((event) -> layout.setCenter(webcastView.getView()));
        viewCursusButton.setOnAction((event) -> layout.setCenter(courseView.getView()));
        viewRecommendedButton.setOnAction((event) -> layout.setCenter(recommendedView.getView()));
        viewPassedButton.setOnAction((event) -> layout.setCenter(passedView.getView()));

        // 2. Creating a view for showing the welcome message
        Label welcomeText = new Label("Welcome, this is the beginning!");

        StackPane welcomeLayout = new StackPane();
        welcomeLayout.setPrefSize(300, 180);
        welcomeLayout.getChildren().add(welcomeText);
        welcomeLayout.setAlignment(Pos.CENTER);

        Scene welcomeView = new Scene(welcomeLayout);

        // Shows the made scene (layout scene) in the application

        windows.setScene(view);
        windows.show();
    }

    //Main program by itself, don't change this methode
    public static void main(String[] args) {
        launch(UI.class);
    }
}
