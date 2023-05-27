import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import java.util.Optional;
import javafx.scene.*;
import javafx.scene.paint.*;
public class ViewPrint
{

    //crea la board
    Board game = new Board();
    Piece[] p = game.getPieces();

    Group root = new Group();
    Scene scene = new Scene(root, Color.SIENNA);

    //---------------------------------------------------------

    //private Stage stage;
    
    // dimensione del lato dei quadrati
    private Rectangle[][] squares;

    void print(Stage primaryStage)
    {

        BoardView printBoard = new BoardView();
        printBoard.printBoard(squares, root);

        PiecesView printPiece = new PiecesView();
        printPiece.printPiece(p, squares, root);


        // modifico lo stage
        primaryStage.setTitle("Klotski Game");
        primaryStage.setHeight(4 * 200);
        primaryStage.setWidth(4 * 200);
        primaryStage.setResizable(false);
        //primaryStage.setFullScreen(true);


        // mostro lo stage
        primaryStage.setScene(scene);
        primaryStage.show();

        //inserimento valori
        InsView ins = new InsView(primaryStage);
        int f = ins.insert(game, p);

        // Show dialog to change position of red square
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.initOwner(primaryStage);
        String s = String.valueOf(f);
        alert.setTitle(s);

        /*
        TextField directionField = new TextField();
        directionField.setPromptText("Direzione");

        // Create buttons for dialog
        ButtonType buttonTypeOk = new ButtonType("OK");

        // Add buttons to dialog
        alert.getButtonTypes().setAll(buttonTypeOk);

        Piece pTemp = p[9];

        int x = pTemp.getDims()[0];
        int y = pTemp.getDims()[1];
        if (game.selectPiece(x, y)) {
            Optional<ButtonType> result = alert.showAndWait();
            while (result.isPresent() && result.get() == buttonTypeOk) {
                try {
                    // Get new direction from user input
                    int direction = Integer.parseInt(directionField.getText());
                } catch (NumberFormatException e) {
                    Errors er = new Errors();
                    er.insErrorType();
                    result = alert.showAndWait(); // Richiedi nuovamente l'input
                } catch (IllegalArgumentException e) {
                    Errors er = new Errors();
                    er.insErrorNumber();
                    result = alert.showAndWait(); // Richiedi nuovamente l'input
                }
            }

        } */
    }
}