import java.util.Optional;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.paint.*;
import javafx.scene.control.Button;
import javafx.scene.Group;
import javafx.scene.control.TextInputDialog;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

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

    Rectangle[] print(Stage primaryStage, Board board, Piece[] p, Button sù, Button giù, Button destra, Button sinistra, Button config1, Button config2, Button config3,Button config4, Button reset, Button undo, Button bestNextMove, Button save, Button caricaPartita)
    {

        printBoard.printBoard(root);

        a = printPiece.printPiece(p, root, board);

        primaryStageSetting.viewSettings(primaryStage);
        
        //inserimento bottoni
        ins.insertButtons(root, sù, giù, destra, sinistra, config1, config2, config3, config4, reset, undo, bestNextMove, save, caricaPartita);

        text.counterText(root, board);

        // mostro lo stage
        primaryStage.setScene(scene);
        primaryStage.show();

        return a;
    }

    void rePrint(Stage primaryStage, Board board, Piece[] p, Button sù, Button giù, Button destra, Button sinistra, Button config1, Button config2, Button config3,Button config4, Button reset, Button undo, Button bestNextMove, Button save, Button caricaPartita)
    {
        printPiece.clearPiece(root);
        printBoard.printBoard(root);
        a = printPiece.rePrintPiece(p, root, board);
        ins.insertButtons(root, sù, giù, destra, sinistra, config1, config2, config3, config4, reset, undo, bestNextMove, save, caricaPartita);
        text.counterText(root, board);
    }
    
    void resetPrint()
    {
        root.getChildren().clear();
    }

    public boolean saveView(Board board)
    {
        TextInputDialog inputDialog = new TextInputDialog();
        String response = "";
        inputDialog.setTitle("SALVA");
        inputDialog.setHeaderText("(salva ed esci)");
        inputDialog.setContentText("Come vuoi salvare la tua partita?");
        Optional<String> result;
        String file;

        while (true)
        {
            result = inputDialog.showAndWait();
            if (result.isPresent())
            {
                response = result.get();
                file = "./Logs/" + response + ".txt";
                Path path = Paths.get(file);
                if(!Files.exists(path))
                {
                    
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
                {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Errore");
                    alert.setHeaderText(null);
                    alert.setContentText("Il nome del file è già utilizzato.");
                    alert.showAndWait();
                }
            }
            else
            {
                return false;
            }
        }
        board.renameFile(response + ".txt");
        return true;
    }

    public void winView(Board board)
    {
        TextInputDialog inputDialog = new TextInputDialog();
        String response = "";
        inputDialog.setTitle("!!!WIN!!!");
        inputDialog.setHeaderText("(salva ed esci)");
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

    public void loadView(Board board)
    {
        TextInputDialog inputDialog = new TextInputDialog();
        Optional<String> result;
        String fileName;
        inputDialog.setTitle("CARICA PARTITA");
        inputDialog.setContentText("Inserisci il nome:");
        result = inputDialog.showAndWait();
        if (result.isPresent())
        {
            fileName = "./Logs/" + result.get() + ".txt";
            Path path = Paths.get(fileName);
            if(Files.exists(path))
            {
                ArrayList<ArrayList<int[]>> q = board.read(fileName);
                ArrayList<int[]> pI = q.get(q.size()-1);
                int cX = 0;
                int cY = 0;
                for (int j = 0; j < 10; j++)
                {
                    cX = pI.get(j)[0];
                    cY = pI.get(j)[1];
                    Piece[] p = board.getPieces();
                    p[j].setDims(cX, cY);
                }
                board.LogRewrite(fileName);
                board.setCounter(q.size()-1);
            }
            else
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Errore");
                alert.setHeaderText(null);
                alert.setContentText("Il file non esiste");
                alert.showAndWait();
            }
        }
        else
        {return;}
    }
}
