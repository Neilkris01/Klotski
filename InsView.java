import javafx.scene.control.Button;
import javafx.scene.*;

public class InsView
{

    void insertButtons(Group root, Button sù, Button giù, Button destra, Button sinistra)
    {
        
        ViewSettings primaryStageSetting = new ViewSettings();
        primaryStageSetting.buttonsSettings(sù, giù, destra, sinistra);

        root.getChildren().add(giù);
        root.getChildren().add(sù);
        root.getChildren().add(destra);
        root.getChildren().add(sinistra);
    }
}
