import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.paint.*;
public class ViewPrint
{

    //crea la board
    Board board = new Board();
    Piece[] p = board.getPieces();

    Group root = new Group();
    Scene scene = new Scene(root, Color.SIENNA);

    
    // dimensione del lato dei quadrati
    private Rectangle[][] squares;

    void print(Stage primaryStage) throws InterruptedException
    {

        BoardView printBoard = new BoardView();
        printBoard.printBoard(squares, root);

        PiecesView printPiece = new PiecesView();
        printPiece.printPiece(p, squares, root);

        ViewSettings primaryStageSetting = new ViewSettings();
        primaryStageSetting.settings(primaryStage);
        
        // mostro lo stage
        primaryStage.setScene(scene);
        primaryStage.show();

        //inserimento valori
        InsView ins = new InsView();
        ins.insertButtons(board, p, root);

           int f = ins.insertValue(board, p, root);
           if (f != -1)
           {
                board.selectPiece(p[9]);
                board.movePiece(f);
                printPiece.clearPiece(root);
                printBoard.printBoard(squares, root);
                printPiece.printPiece(p, squares, root);
                ins.insertButtons(board, p, root);
            }
    }
}