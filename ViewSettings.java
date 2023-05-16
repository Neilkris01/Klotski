import javafx.scene.layout.StackPane;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ViewSettings
{
    void settings(StackPane stackPane, Stage primaryStage)
    {
        // Set the background color of the scene
        stackPane.setStyle("-fx-background-color: lightgray;");
        // Set the scene on the stage
        Scene scene = new Scene(stackPane, 500, 500, Color.LIGHTGRAY);
        primaryStage.setScene(scene);
        // titolo finestra
        primaryStage.setTitle("ViewPoint");
        primaryStage.show();
    }
}
