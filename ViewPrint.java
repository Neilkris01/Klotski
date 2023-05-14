import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import java.util.Optional;

public class ViewPrint {
    Board board = new Board();
    Piece[] p = board.getPieces();
    
    private int squareSize = 80; // dimensione del lato dei quadrati
    private Rectangle[][] squares;

    void print(Stage primaryStage) {
        // Create rectangles for each square in the grid
        BoardView boardView = new BoardView();
        squares = new Rectangle[5][4];
        boardView.createBoard(squares, squareSize);

        // Set up the initial state of the game
        PiecesView piecesView = new PiecesView();
        piecesView.printPiece(p, squares);

        // Create a layout grid for the squares
        // Add the squares to the grid
        // Create the root group and add the grid to it
        // Create the scene and set its dimensions
        // Set the scene on the stage and display the stage
        boardView.gridLayout(squares, primaryStage);


        boolean selected = board.selectPiece(p[9].getDims()[0], p[9].getDims()[1]);

        //Da separare

        // Show dialog to change position of red square
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Muovi il quadrato");
        alert.setHeaderText("dx, sx, su o giù?");

        // Create input fields for X and Y coordinates
        TextField xField = new TextField();
        xField.setPromptText("Direzione");

        // Create layout for input fields
        GridPane gridPane = new GridPane();
        gridPane.add(xField, 0, 0);

        // Add input fields to dialog
        alert.getDialogPane().setContent(gridPane);

        // Create buttons for dialog
        ButtonType buttonTypeOk = new ButtonType("OK");
        // ButtonType buttonTypeCancel = new ButtonType("Cancel");

        // Add buttons to dialog
        alert.getButtonTypes().setAll(buttonTypeOk);

        Optional<ButtonType> result = alert.showAndWait();
        boolean canMove = false;
        while (result.isPresent() && result.get() == buttonTypeOk) {
            try {
                // Get new direction from user input
                int direzione = Integer.parseInt(xField.getText());

                if (selected) {
                    canMove = board.movePiece(direzione);
                    if (canMove) {
                        // Close the existing view
                        primaryStage.close();

                        // Update the view if the move was successful
                        Stage newStage = new Stage();
                        print(newStage);
                    }
                }
                break; // Esci dal loop se l'input è corretto
            } catch (NumberFormatException e)
            {
                Errors er = new Errors();
                er.insError();
                result = alert.showAndWait(); // Richiedi nuovamente l'input
            }
        }
    }
}