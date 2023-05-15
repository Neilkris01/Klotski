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
    }
}