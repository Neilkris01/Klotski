import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.*;
import javafx.scene.paint.*;
public class ViewPrint
{

    //crea la board
    Board game = new Board();
    Piece[] p = game.getPieces();

    Group root = new Group();
    Scene scene = new Scene(root, Color.SIENNA);

    
    // dimensione del lato dei quadrati
    private Rectangle[][] squares;

    void print(Stage primaryStage)
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
        InsView ins = new InsView(primaryStage);
        int f = ins.insertValue(game, p, root);

        // Show dialog to change position of red square
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.initOwner(primaryStage);
        String s = String.valueOf(f);
        alert.setTitle(s);

        if(f == 1)
        {
            printPiece.clearPiece(root);
            printBoard.printBoard(squares, root);
            printPiece.printPiece(p, squares, root);
        }
        
    }
}