import javafx.scene.control.Button;
import javafx.scene.*;

public class InsView
{

    void insertButtons(Group root, Button sù, Button giù, Button destra, Button sinistra, Button config1, Button config2, Button config3, Button config4, Button reset, Button undo, Button bestNextMove, Button save, Button caricaPartita)
    {
        
        ViewSettings primaryStageSetting = new ViewSettings();
        primaryStageSetting.buttonsSettings(sù, giù, destra, sinistra, config1, config2, config3, config4, reset, undo, bestNextMove, save, caricaPartita);

        root.getChildren().add(giù);
        root.getChildren().add(sù);
        root.getChildren().add(destra);
        root.getChildren().add(sinistra);
        root.getChildren().add(reset);
        root.getChildren().add(config1);
        root.getChildren().add(config2);
        root.getChildren().add(config3);
        root.getChildren().add(config4);
        root.getChildren().add(undo);
        root.getChildren().add(bestNextMove);
        root.getChildren().add(save);
        root.getChildren().add(caricaPartita);
    }
}
