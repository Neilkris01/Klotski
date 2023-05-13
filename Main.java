import javafx.application.Application;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {

    Board board = new Board();
    Piece[] p = board.getPieces();

    private int squareSize = 50; // dimensione del lato dei quadrati

    @Override
    public void start(Stage primaryStage) throws Exception {

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

    public static void main(String[] args) {
        launch(args);
    }
}