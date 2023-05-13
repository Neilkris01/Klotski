import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ViewPrint
{
    Board board = new Board();
    Piece[] p = board.getPieces();

    private int squareSize = 100; // dimensione del lato dei quadrati
    void print(Stage primaryStage)
    {
        // Create rectangles for each square in the grid
        BoardView boardView = new BoardView();
        Rectangle[][] squares = new Rectangle[5][4];
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
    }
}
