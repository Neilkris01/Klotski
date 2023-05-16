import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import java.util.Optional;
public class ViewPrint
{

    //crea la board
    Board board = new Board();
    Piece[] p = board.getPieces();

    private Stage stage;
    
    // dimensione del lato dei quadrati
    private int squareSize = 80; 
    private Rectangle[][] squares;

    void print(Stage primaryStage)
    {
        // Create rectangles for each square in the grid
        BoardView boardView = new BoardView();
        squares = new Rectangle[5][4];
        boardView.createBoard(squares, squareSize);

        // Set up the initial state of the game
        PiecesView piecesView = new PiecesView();
        piecesView.printPiece(p, squares);

        // Create a la finestra
        boardView.gridLayout(squares, primaryStage);

        //inserimento valori
        InsView ins = new InsView(primaryStage);
        int a = ins.insert(board, p);

        // Show dialog to change position of red square
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.initOwner(stage);
        String s = String.valueOf(a);
        alert.setTitle(s);

        TextField directionField = new TextField();
        directionField.setPromptText("Direzione");

        // Create buttons for dialog
        ButtonType buttonTypeOk = new ButtonType("OK");

        // Add buttons to dialog
        alert.getButtonTypes().setAll(buttonTypeOk);

        Piece pTemp = p[9];

        int x = pTemp.getDims()[0];
        int y = pTemp.getDims()[1];
        if (board.selectPiece(x, y)) {
            Optional<ButtonType> result = alert.showAndWait();
            while (result.isPresent() && result.get() == buttonTypeOk) {
                try {
                    // Get new direction from user input
                    int direction = Integer.parseInt(directionField.getText());
                } catch (NumberFormatException e) {
                    Errors er = new Errors();
                    er.insErrorType();
                    result = alert.showAndWait(); // Richiedi nuovamente l'input
                } catch (IllegalArgumentException e) {
                    Errors er = new Errors();
                    er.insErrorNumber();
                    result = alert.showAndWait(); // Richiedi nuovamente l'input
                }
            }

        }
        ;
        
    }
}