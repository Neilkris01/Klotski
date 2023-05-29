import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.control.Button;
public class ViewPrint
{

    //crea la board


    Group root = new Group();
    Scene scene = new Scene(root, Color.SIENNA);

    BoardView printBoard = new BoardView();
    PiecesView printPiece = new PiecesView();
    ViewSettings primaryStageSetting = new ViewSettings();
    InsView ins = new InsView();

    // dimensione del lato dei quadrati
    private Rectangle[][] squares;

    void print(Stage primaryStage, Board board, Piece[] p, Button sù, Button giù, Button destra, Button sinistra, Button config1, Button config2, Button config3, Button reset, Button undo)
    {

        printBoard.printBoard(squares, root);

        printPiece.printPiece(p, squares, root);

        primaryStageSetting.viewSettings(primaryStage);
        
        //inserimento bottoni
        ins.insertButtons(root, sù, giù, destra, sinistra, config1, config2, config3, reset, undo);

        // mostro lo stage
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    void rePrint(Stage primaryStage, Board board, Piece[] p, Button sù, Button giù, Button destra, Button sinistra, Button config1, Button config2, Button config3, Button reset, Button undo)
    {
            printPiece.clearPiece(root);
            printBoard.printBoard(squares, root);
            printPiece.printPiece(p, squares, root);
            ins.insertButtons(root, sù, giù, destra, sinistra, config1, config2, config3, reset, undo);

    }
}
