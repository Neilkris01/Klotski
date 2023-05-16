import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ViewPrint {

    //crea la board
    Board board = new Board();
    Piece[] p = board.getPieces();
    
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
    }
}