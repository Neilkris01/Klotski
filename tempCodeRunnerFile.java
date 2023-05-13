
/*
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CoordinatesGUI extends Application {

    private TextField xField;
    private TextField yField;
    private Label outputLabel;

    @Override
    public void start(Stage primaryStage) {

        // Create a grid pane for the input fields
        GridPane inputGrid = new GridPane();
        inputGrid.setAlignment(Pos.CENTER);
        inputGrid.setHgap(10);
        inputGrid.setVgap(10);
        inputGrid.setPadding(new Insets(25, 25, 25, 25));

        // Add labels and text fields for the x and y coordinates
        Label xLabel = new Label("X coordinate:");
        inputGrid.add(xLabel, 0, 0);
        xField = new TextField();
        inputGrid.add(xField, 1, 0);

        Label yLabel = new Label("Y coordinate:");
        inputGrid.add(yLabel, 0, 1);
        yField = new TextField();
        inputGrid.add(yField, 1, 1);

        // Create a button to submit the coordinates
        Button submitButton = new Button("Submit");
        submitButton.setOnAction(event -> submitCoordinates());

        // Add the input fields and submit button to a vertical box
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(10);
        vbox.getChildren().addAll(inputGrid, submitButton);

        // Add a label to display the output
        outputLabel = new Label();
        outputLabel.setPadding(new Insets(10, 0, 0, 0));

        // Add the vbox and output label to an HBox
        HBox hbox = new HBox();
        hbox.setAlignment(Pos.CENTER);
        hbox.getChildren().addAll(vbox, outputLabel);

        // Set up the scene and show the stage
        Scene scene = new Scene(hbox, 400, 150);
        primaryStage.setTitle("Coordinates GUI");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void submitCoordinates() {
        try {
            int x = Integer.parseInt(xField.getText());
            int y = Integer.parseInt(yField.getText());
            // Do something with the coordinates, e.g. update piece position
            outputLabel.setText("Coordinates submitted: x = " + x + ", y = " + y);
        } catch (NumberFormatException e) {
            outputLabel.setText("Invalid input, please enter integers for x and y coordinates");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
*/