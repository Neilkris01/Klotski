import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ViewSettings
{
    void settings(AnchorPane window, Stage primaryStage, GridPane gridPane)
    {
        // Set the background color of the scene
        window.setStyle("-fx-background-color: darkgray;");
        // Set the scene on the stage
        Scene scene = new Scene(window, 500, 500, Color.LIGHTGRAY);
        primaryStage.setScene(scene);
        // titolo finestra
        primaryStage.setTitle("ViewPoint");
        
        // Set the alignment of the GridPane to center it within the AnchorPane
        AnchorPane.setTopAnchor(gridPane, 30.0);
        AnchorPane.setLeftAnchor(gridPane, 0.0);
        AnchorPane.setRightAnchor(gridPane, 0.0);
        AnchorPane.setBottomAnchor(gridPane, 0.0);

        primaryStage.show();
    }
} 
