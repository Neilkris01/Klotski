import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import java.util.Optional;
import javafx.stage.Stage;

public class InsView
{
    private Stage stage;

    public InsView(Stage primaryStage)
    {
        stage = primaryStage;
    }

    int insert(Board board, Piece[] p)
    {
        // Show dialog to change position of red square
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.initOwner(stage);
        alert.setTitle("Muovi il quadrato");
        alert.setHeaderText("dx, sx, su o giù?"); 

        // Create input fields for direction
        TextField directionField = new TextField();
        directionField.setPromptText("Direzione");

        // Create layout for input fields
        GridPane gridPane = new GridPane();
        gridPane.add(directionField, 0, 0);

        // Add input fields to dialog
        alert.getDialogPane().setContent(gridPane);

        // Create buttons for dialog
        ButtonType buttonTypeOk = new ButtonType("OK");

        // Add buttons to dialog
        alert.getButtonTypes().setAll(buttonTypeOk);
        
        Piece pTemp = p[9];

        int x = pTemp.getDims()[0];
        int y = pTemp.getDims()[1];
        if(board.selectPiece(x, y))
        {
          Optional<ButtonType> result = alert.showAndWait();
            while (result.isPresent() && result.get() == buttonTypeOk)
            {
                try
                {
                    // Get new direction from user input
                    int direction = Integer.parseInt(directionField.getText());
                    if (board.movePiece(direction))
                    {
                        return 1;
                    }
                    else
                    return 0;
                }
                catch (NumberFormatException e)
                {
                    Errors er = new Errors();
                    er.insErrorType();
                    result = alert.showAndWait(); // Richiedi nuovamente l'input
                }
                catch (IllegalArgumentException e)
                {
                    Errors er = new Errors();
                    er.insErrorNumber();
                    result = alert.showAndWait(); // Richiedi nuovamente l'input
                }
            }
        }
        return 0;
    }
}
