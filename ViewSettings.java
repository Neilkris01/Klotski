import javafx.stage.Stage;
public class ViewSettings
{
    void settings(Stage primaryStage)
    {
        // modifico lo stage
        primaryStage.setTitle("Klotski Game");
        primaryStage.setHeight(4 * 200);
        primaryStage.setWidth(4 * 200);
        primaryStage.setResizable(false);
        // primaryStage.setFullScreen(true);
    }
} 
