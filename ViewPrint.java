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
    //Create the root group and scene
    Group root = new Group();
    Scene scene = new Scene(root, Color.SIENNA);

    //Initialize necessary views and components
    BoardView printBoard = new BoardView();
    PiecesView printPiece = new PiecesView();
    ViewSettings primaryStageSetting = new ViewSettings();
    InsView ins = new InsView();
    Texts text = new Texts();
    Rectangle[] a;

    //Print the board, pieces, buttons, and text on the scene
    Rectangle[] print(Stage primaryStage, Board board, Piece[] p, Button up, Button down, Button rigth, Button sinistra, Button config1, Button config2, Button config3,Button config4, Button reset, Button undo, Button bestNextMove, Button save, Button loadGame)
    {

        printBoard.printBoard(root);

        a = printPiece.printPiece(p, root, board);

        primaryStageSetting.viewSettings(primaryStage);
        
        //inserimento bottoni
        ins.insertButtons(root, up, down, rigth, sinistra, config1, config2, config3, config4, reset, undo, bestNextMove, save, loadGame);

        text.counterText(root, board);

        // mostro lo stage
        primaryStage.setScene(scene);
        primaryStage.show();

        return a;
    }

    //Repaint the board, pieces, buttons, and text on the scene
    void rePrint(Stage primaryStage, Board board, Piece[] p, Button up, Button down, Button rigth, Button sinistra, Button config1, Button config2, Button config3,Button config4, Button reset, Button undo, Button bestNextMove, Button save, Button loadGame)
    {
        printPiece.clearPiece(root);
        printBoard.printBoard(root);
        a = printPiece.rePrintPiece(p, root, board);
        ins.insertButtons(root, up, down, rigth, sinistra, config1, config2, config3, config4, reset, undo, bestNextMove, save, loadGame);
        text.counterText(root, board);
    }
    
    //Clear the scene
    void resetPrint()
    {
        root.getChildren().clear();
    }

    //Save the current game state to a file
    public boolean saveView(Board board, LogFile log)
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
                else if(response.equals("Config1Database"))
                {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Errore");
                    alert.setHeaderText(null);
                    alert.setContentText("Il nome del file è già utilizzato. (DataBase)");
                    alert.showAndWait();
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
        log.renameFile(response + ".txt");
        return true;
    }

    //Show a win message and prompt for saving the game state
    public void winView(Board board, LogFile log)
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
        log.renameFile(response + ".txt");
    }

    //Load a game state from a file
    public void loadView(Board board, LogFile log)
    {
        TextInputDialog inputDialog = new TextInputDialog();
        Optional<String> result;
        String fileName;
        inputDialog.setTitle("CARICA PARTITA");
        inputDialog.setContentText("Inserisci il nome del file da caricare:");
        result = inputDialog.showAndWait();
        if(result.get().equals("Config1Database"))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Errore");
            alert.setHeaderText(null);
            alert.setContentText("Il file non può essere caricato (DataBase)");
            alert.showAndWait();
        }
        if (result.isPresent())
        {
            fileName = "./Logs/" + result.get() + ".txt";
            Path path = Paths.get(fileName);
            if(Files.exists(path))
            {
                ArrayList<ArrayList<int[]>> q = log.read(fileName);
                ArrayList<int[]> pI = q.get(q.size()-1);
                int cX = 0;
                int cY = 0;
                for (int j = 0; j < 10; j++)
                {
                    cX = pI.get(j)[0];
                    cY = pI.get(j)[1];
                    Piece[] p = board.getPieces();
                    p[j].setPos(cX, cY);
                }
                log.LogRewrite(fileName);
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
