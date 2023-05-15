import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import java.util.Optional;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class InsView {
    private Rectangle[][] squares;
    private Stage stage;

    public InsView(Stage primaryStage) {
        stage = primaryStage;
    }

    int insert(int x, int y, Board board) {
        Piece[] p = board.getPieces();
        squares = new Rectangle[5][4];
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

        boolean selected = board.selectPiece(x, y);

        Optional<ButtonType> result = alert.showAndWait();
        boolean canMove = false;
        while (result.isPresent() && result.get() == buttonTypeOk) {
            try {
                // Get new direction from user input
                int direction = Integer.parseInt(directionField.getText());

                // Check that direction is in the range [0, 3]
                if (direction < 0 || direction > 3) {
                    throw new IllegalArgumentException("La direzione deve essere un numero intero tra 0 e 3.");
                }
                int a = direction;
                return a;

            } catch (NumberFormatException e) {
                Errors er = new Errors();
                er.insError();
                result = alert.showAndWait(); // Richiedi nuovamente l'input
            } catch (IllegalArgumentException e) {
                Errors er = new Errors();
                er.insError();
                result = alert.showAndWait(); // Richiedi nuovamente l'input
            }
        }
        int b = 1;
        return b;
    }
}
