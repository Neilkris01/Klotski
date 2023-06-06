import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.control.Button;
import javafx.scene.Group;
public class ViewPrint
{

    //crea la board


    Group root = new Group();
    Scene scene = new Scene(root, Color.SIENNA);

    BoardView printBoard = new BoardView();
    PiecesView printPiece = new PiecesView();
    ViewSettings primaryStageSetting = new ViewSettings();
    InsView ins = new InsView();
    Texts text = new Texts();
    Rectangle[] a;

    Rectangle[] print(Stage primaryStage, Board board, Piece[] p, Button sù, Button giù, Button destra, Button sinistra, Button config1, Button config2, Button config3, Button reset, Button undo, Button bestNextMove, Button save)
    {

        printBoard.printBoard(root);

        a = printPiece.printPiece(p, root, board);

        primaryStageSetting.viewSettings(primaryStage);
        
        //inserimento bottoni
        ins.insertButtons(root, sù, giù, destra, sinistra, config1, config2, config3, reset, undo, bestNextMove, save);

        text.counterText(root, board);

        // mostro lo stage
        primaryStage.setScene(scene);
        primaryStage.show();

        return a;
    }

    Rectangle[] rePrint(Stage primaryStage, Board board, Piece[] p, Button sù, Button giù, Button destra, Button sinistra, Button config1, Button config2, Button config3, Button reset, Button undo, Button bestNextMove, Button save)
    {
        printPiece.clearPiece(root);
        printBoard.printBoard(root);
        a = printPiece.printPiece(p, root, board);
        ins.insertButtons(root, sù, giù, destra, sinistra, config1, config2, config3, reset, undo, bestNextMove, save);
        text.counterText(root, board);
        return a;
    }
    
    void resetPrint()
    {
        root.getChildren().clear();
    }
}
