import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ViewPrint {
    Board board = new Board();
    Piece[] p = board.getPieces();

    void print(Stage primaryStage) {
        AnchorPane root = new AnchorPane();

        // Create rectangles for each square in the grid
        BoardView boardView = new BoardView();
        Rectangle[][] squares = new Rectangle[5][4];
        int squareSize = 50;
        boardView.createBoard(squares, squareSize);

        // Define the size of the rectangles based on the window size
        primaryStage.widthProperty().addListener((obs, oldVal, newVal) -> {
            double newSquareSize = newVal.doubleValue() / 5;
            boardView.updateBoard(squares, newSquareSize);
        });
        primaryStage.heightProperty().addListener((obs, oldVal, newVal) -> {
            double newSquareSize = newVal.doubleValue() / 4;
            boardView.updateBoard(squares, newSquareSize);
        });

        // Set up the initial state of the game
        PiecesView piecesView = new PiecesView();
        piecesView.printPiece(p, squares);

        // Define the position of the pieces based on the window size
        root.widthProperty().addListener((obs, oldVal, newVal) -> {
            double xScale = newVal.doubleValue() / oldVal.doubleValue();
            for (Piece piece : p) {
                piece.setLayoutX(piece.getLayoutX() * xScale);
            }
        });
        root.heightProperty().addListener((obs, oldVal, newVal) -> {
            double yScale = newVal.doubleValue() / oldVal.doubleValue();
            for (Piece piece : p) {
                piece.setLayoutY(piece.getLayoutY() * yScale);
            }
        });

        // Add the squares and pieces to the root pane
        root.getChildren().addAll(boardView.getGrid(), piecesView.getGroup());

        // Set the scene on the stage and display the stage 
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
