import javafx.scene.control.Button;
import javafx.stage.Stage;
public class ViewSettings
{
    void viewSettings(Stage primaryStage)
    {
        // modifico lo stage
        primaryStage.setTitle("Klotski Game");
        primaryStage.setHeight(4 * 200);
        primaryStage.setWidth(4 * 200);
        primaryStage.setResizable(false);
        // primaryStage.setFullScreen(true);
    }

    void buttonsSettings(Button sù, Button giù, Button destra, Button sinistra)
    {
        sù.setLayoutX(615);
        sù.setLayoutY(350);

        giù.setLayoutX(615);
        giù.setLayoutY(450);

        destra.setLayoutX(650);
        destra.setLayoutY(400);

        sinistra.setLayoutX(550);
        sinistra.setLayoutY(400);
    }
} 
