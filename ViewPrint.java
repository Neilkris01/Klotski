import java.util.Optional;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.paint.*;
import javafx.scene.control.Button;
import javafx.scene.Group;
import javafx.scene.control.TextInputDialog;
import javafx.scene.Scene;
import javafx.scene.control.Alert;

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

    public void saveView(Board board)
    {
        TextInputDialog inputDialog = new TextInputDialog();
        String response = "";
        inputDialog.setTitle("Salva");
        inputDialog.setHeaderText(null);
        inputDialog.setContentText("Come vuoi salvare la tua partita?");
        Optional<String> result;

        while (true)
        {
            result = inputDialog.showAndWait();
            if (result.isPresent()) 
            {
                response = result.get();
                if (!response.equals("out"))
                {break;}
                else
                {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Errore");
                    alert.setHeaderText(null);
                    alert.setContentText("L'input non può essere 'out'. Inserisci un valore diverso.");
                    alert.showAndWait();
                }
            }
            else
            {return;}
        }
        board.renameFile(response + ".txt");
    }

    public void winView(Board board)
    {
        TextInputDialog inputDialog = new TextInputDialog();
        String response = "";
        inputDialog.setTitle("!!!WIN!!!");
        inputDialog.setHeaderText(null);
        inputDialog.setContentText("Vuoi salvare la tua partita?");
        Optional<String> result;
        while (true)
        {
            result = inputDialog.showAndWait();
            if (result.isPresent())
            {
                response = result.get();
                if (!response.equals("out"))
                {break;}
                else
                {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Errore");
                    alert.setHeaderText(null);
                    alert.setContentText("L'input non può essere 'out'. Inserisci un valore diverso.");
                    alert.showAndWait();
                }
            }
            else
            {return;}
        }
        board.renameFile(response + ".txt");
    }
}
