import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import java.util.Optional;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.*;
public class InsView
{
    private Stage stage;
    private int result = -1;

    public InsView(Stage primaryStage)
    {
        stage = primaryStage;
    }

    int insertValue(Board board, Piece[] p, Group root)
    {

        int result = -1;

        Button sù = new Button("sù");
        sù.setOnAction(event -> {
            result = 0;
        });

        sù.setLayoutX(615);
        sù.setLayoutY(350);

        Button giù = new Button("giù");
        giù.setOnAction(event -> {
            result = 2;
        });

        giù.setLayoutX(615);
        giù.setLayoutY(450);

        Button destra = new Button("destra");
        destra.setOnAction(event -> {
            result = 1;
        });

        destra.setLayoutX(650);
        destra.setLayoutY(400);

        Button sinistra = new Button("sinistra");
        sinistra.setOnAction(event -> {
            result = 3;
        });

        sinistra.setLayoutX(550);
        sinistra.setLayoutY(400);

        root.getChildren().add(giù);
        root.getChildren().add(sù);
        root.getChildren().add(destra);
        root.getChildren().add(sinistra);
        
        return result;
    }
}
