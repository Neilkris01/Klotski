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

    void buttonsSettings(Button sù, Button giù, Button destra, Button sinistra, Button config1, Button config2, Button config3, Button reset, Button undo, Button bestNextMove, Button save)
    {
        sù.setLayoutX(615);
        sù.setLayoutY(350);
        sù.setMinSize(50, 10);

        giù.setLayoutX(615);
        giù.setLayoutY(450);
        giù.setMinSize(50, 10);

        destra.setLayoutX(670);
        destra.setLayoutY(400);
        destra.setMinSize(50, 10);

        sinistra.setLayoutX(550);
        sinistra.setLayoutY(400);
        sinistra.setMinSize(50, 10);

        config1.setLayoutX(580);
        config1.setLayoutY(100);
        config1.setMinSize(50, 10);

        config2.setLayoutX(580);
        config2.setLayoutY(130);
        config2.setMinSize(50, 10);

        config3.setLayoutX(580);
        config3.setLayoutY(160);
        config3.setMinSize(50, 10);

        reset.setLayoutX(650);
        reset.setLayoutY(580);
        reset.setMinSize(50, 10);

        undo.setLayoutX(590);
        undo.setLayoutY(580);
        undo.setMinSize(50, 10);

        bestNextMove.setLayoutX(580);
        bestNextMove.setLayoutY(190);
        bestNextMove.setMinSize(50, 10);

        save.setLayoutX(650);
        save.setLayoutY(610);
        save.setMinSize(50, 10);
    }
} 
